package com.studioP.noticeDuriNew.User.service;

import com.studioP.noticeDuriNew.Department.repository.DepartmentRepository;
import com.studioP.noticeDuriNew.User.entity.dto.RegisterForm;
import com.studioP.noticeDuriNew.User.entity.User;
import com.studioP.noticeDuriNew.User.exception.ExistsLoginId;
import com.studioP.noticeDuriNew.User.exception.KakaoAccountNotFoundException;
import com.studioP.noticeDuriNew.User.exception.LoginFailedException;
import com.studioP.noticeDuriNew.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    @Transactional
    public User login(String loginId, String password) {
        // 아이디로 사용자 조회
        User user = getUserByLoginId(loginId);

        // 비밀번호 검증
        if (!user.getPassword().equals(password)) {
            /*todo 트랜잭션에서 예외 발생 시 롤백되어 user failedLoginCount update 안되는 문제 */
            handleFailedLogin(user);
            throw new LoginFailedException("아이디 또는 비밀번호가 맞지 않습니다.");
        }

        if (user.isLock()) {
            throw new LoginFailedException("비밀번호 오류 5회 이상으로 인해 계정이 잠금된 상태입니다. 관리자에게 문의하세요.");
        }

        // 로그인 성공
        user.unlock();
        return user;
    }

    @Transactional
    public User register(RegisterForm form) {
        User user = new User(form.getLoginId(), form.getName(), form.getPassword(), form.getKakaoId(), form.getEmail(), null, form.isMarketingReceiveAgree());

        if (existsByLoginId(user.getLoginId())) {
            throw new ExistsLoginId("이미 존재하는 아이디입니다.", form);
        }
        //todo 존재하지 않는 학과 ID
/*        if (departmentRepository.existsById(user.getDepartment().getId())) {
            throw new
        }*/
        return userRepository.save(user);
    }

    /*    =========== Utils ===========     */

    @Transactional
    public void handleFailedLogin(User user) {
        if (user.increaseFailedLoginCount() >= 5) {
            user.lock();
        }
    }

    public List<User> getUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean existsByLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    public User getUserByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).orElseThrow(() -> new LoginFailedException("아이디 또는 비밀번호가 맞지 않습니다."));
    }

    public User getUserByKakaoId(Long kakaoId) {
        return userRepository.findByKakaoId(kakaoId).orElseThrow(KakaoAccountNotFoundException::new);
    }
}

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
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;

    public User login(String loginId, String password) {
        return userRepository.findByLoginIdAndPassword(loginId, password)
                .orElseThrow(() -> new LoginFailedException("아이디 또는 비밀번호가 맞지 않습니다."));
    }

    @Transactional
    public User register(RegisterForm form) {
        User user = new User(form.getLoginId(), form.getName(), form.getPassword(), form.getKakaoId(), form.getEmail(), null);

        if (userRepository.existsByLoginId(user.getLoginId())) {
            throw new ExistsLoginId("이미 존재하는 아이디입니다.", form);
        }
        //todo 존재하지 않는 학과 ID
/*        if (departmentRepository.existsById(user.getDepartment().getId())) {
            존재하지 않은 학과ID
            throw new
        }*/
        return userRepository.save(user);
    }

    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Boolean existsLoginId(String loginId) {
        return userRepository.existsByLoginId(loginId);
    }

    public User findByKakaoId(Long kakaoId) {
        return userRepository.findByKakaoId(kakaoId).orElseThrow(KakaoAccountNotFoundException::new);
    }

    public User findByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId).orElseThrow(NoSuchElementException::new);
    }
}

package com.studioP.noticeDuriNew.User.service;

import com.studioP.noticeDuriNew.User.entity.User;
import com.studioP.noticeDuriNew.User.exception.LoginFailedException;
import com.studioP.noticeDuriNew.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User login(String loginId, String password) {
        return userRepository.findByLoginIdAndPassword(loginId, password)
                .orElseThrow(() -> new LoginFailedException("아이디 또는 비밀번호가 맞지 않습니다."));
    }
}

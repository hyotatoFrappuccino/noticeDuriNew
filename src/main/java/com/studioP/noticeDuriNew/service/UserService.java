package com.studioP.noticeDuriNew.service;

import com.studioP.noticeDuriNew.entity.User;
import com.studioP.noticeDuriNew.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void login(String username, String password) {
        userRepository.save(new User(1L, username));
    }
}

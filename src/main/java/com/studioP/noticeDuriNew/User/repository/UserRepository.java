package com.studioP.noticeDuriNew.User.repository;

import com.studioP.noticeDuriNew.User.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginIdAndPassword(String loginId, String password);
    boolean existsByLoginId(String loginId);
    Optional<User> findByKakaoId(Long kakaoId);
    List<User> findByEmail(String email);
    Optional<User> findByLoginId(String loginId);
}

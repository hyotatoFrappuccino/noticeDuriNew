package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(name = "kakao_id")
    private Long kakaoId;

    @Column(name = "user_name")
    private String username;

    private String password;

    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "failed_login_count")
    private int failedLoginCount;

    @Column(name = "is_lock")
    private boolean isLock;

    @Column(name = "locked_date")
    private LocalDateTime lockedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "user")
    private List<Notification> notificationList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Suggestion> suggestionList = new ArrayList<>();

    public User(Long kakaoId, String username, String password, String email, Department department) {
        this.kakaoId = kakaoId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.USER;
        this.department = department;
    }
}

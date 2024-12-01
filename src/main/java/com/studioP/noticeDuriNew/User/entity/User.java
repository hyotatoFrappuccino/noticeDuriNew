package com.studioP.noticeDuriNew.User.entity;

import com.studioP.noticeDuriNew.Department.entity.Department;
import com.studioP.noticeDuriNew.utils.Enum.Role;
import com.studioP.noticeDuriNew.Notification.entity.Notification;
import com.studioP.noticeDuriNew.Suggestion.entity.Suggestion;
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

    @Column(name = "login_id")
    private String loginId;

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

    public User(String loginId, String username, String password, Long kakaoId, String email, Department department) {
        this.loginId = loginId;
        this.username = username;
        this.password = password;
        this.kakaoId = kakaoId;
        this.email = email;
        this.role = Role.USER;
        this.department = department;
    }

    public void changePassword(String password) {
        this.password = password;
    }

    public int increaseFailedLoginCount() {
        return ++this.failedLoginCount;
    }

    public void lock() {
        this.isLock = true;
        this.lockedDate = LocalDateTime.now();
    }

    public void unlock() {
        this.failedLoginCount = 0;
        this.isLock = false;
        this.lockedDate = null;
    }
}

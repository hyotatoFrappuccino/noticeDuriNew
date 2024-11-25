package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Suggestion {

    @Id
    @GeneratedValue
    @Column(name = "suggestion_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    private String adminResponse;

    public Suggestion(User user, String title, String content, STATUS status, String adminResponse) {
        this.user = user;
        this.title = title;
        this.content = content;
        this.status = status;
        this.adminResponse = adminResponse;
    }
}

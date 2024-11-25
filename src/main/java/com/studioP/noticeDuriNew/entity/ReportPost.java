package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "report_post")
public class ReportPost {

    @Id
    @GeneratedValue
    @Column(name = "report_post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String reason;

    private STATUS status;

    public ReportPost(Post comment, User user, String reason) {
        this.comment = comment;
        this.user = user;
        this.reason = reason;
        this.status = STATUS.RECEIVED;
    }
}

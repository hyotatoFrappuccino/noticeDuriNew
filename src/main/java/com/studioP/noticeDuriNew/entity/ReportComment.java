package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "report_comment")
public class ReportComment {

    @Id
    @GeneratedValue
    @Column(name = "report_comment_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String reason;

    private STATUS status;

    public ReportComment(Comment comment, User user, String reason) {
        this.comment = comment;
        this.user = user;
        this.reason = reason;
        this.status = STATUS.RECEIVED;
    }
}

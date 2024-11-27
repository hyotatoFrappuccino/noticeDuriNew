package com.studioP.noticeDuriNew.Blacklist.entity;

import com.studioP.noticeDuriNew.User.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Blacklist {

    @Id
    @GeneratedValue
    @Column(name = "blacklist_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    private String reason;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "added_user_id")
    private User addedBy;

    public Blacklist(User user, String reason, User addedBy) {
        this.user = user;
        this.reason = reason;
        this.addedBy = addedBy;
    }
}

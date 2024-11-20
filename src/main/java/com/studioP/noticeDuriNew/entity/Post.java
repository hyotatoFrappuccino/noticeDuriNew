package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String title;

    private String content;

    @Column(name = "view_count")
    private int viewCount;

    public Post(Campus campus, User user, Category category, String title, String content) {
        this.campus = campus;
        this.user = user;
        this.category = category;
        this.title = title;
        this.content = content;
    }
}

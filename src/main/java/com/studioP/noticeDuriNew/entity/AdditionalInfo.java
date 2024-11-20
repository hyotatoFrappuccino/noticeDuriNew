package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AdditionalInfo {

    @Id
    @GeneratedValue
    @Column(name = "additional_info_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

//    private ? info_type;

    private String title;

    private String content;

    private String url;

    public AdditionalInfo(Category category, String title, String content, String url) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.url = url;
    }
}

package com.studioP.noticeDuriNew.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {

    @Id
    @GeneratedValue
    @Column(name = "schedule_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    private LocalDateTime date;

    private String title;

    private String description;

    public Schedule(Campus campus, LocalDateTime date, String title, String description) {
        this.campus = campus;
        this.date = date;
        this.title = title;
        this.description = description;
    }

}

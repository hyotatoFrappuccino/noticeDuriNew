package com.studioP.noticeDuriNew.Schedule.entity;


import com.studioP.noticeDuriNew.Campus.entity.Campus;
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

    @Column(name = "upload_date")
    private LocalDateTime uploadDate;

    private String title;

    private String description;

    public Schedule(Campus campus, LocalDateTime uploadDate, String title, String description) {
        this.campus = campus;
        this.uploadDate = uploadDate;
        this.title = title;
        this.description = description;
    }

}

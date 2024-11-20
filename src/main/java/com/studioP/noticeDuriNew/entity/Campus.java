package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Campus {

    @Id
    @GeneratedValue
    @Column(name = "campus_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "college_id")
    private College college;

    @OneToMany(mappedBy = "campus")
    private List<Department> departmentList = new ArrayList<>();

    @OneToMany(mappedBy = "campus")
    private List<Schedule> scheduleList = new ArrayList<>();

    public Campus(String name, College college) {
        this.name = name;
        this.college = college;
    }
}

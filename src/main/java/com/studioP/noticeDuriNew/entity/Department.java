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
public class Department {

    @Id
    @GeneratedValue
    @Column(name = "department_id")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "campus_id")
    private Campus campus;

    @OneToMany(mappedBy = "department")
    private List<User> userList = new ArrayList<>();

    public Department(Campus campus, String name) {
        this.campus = campus;
        this.name = name;
    }
}

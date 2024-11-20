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
public class College {

    @Id
    @GeneratedValue
    @Column(name = "college_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "college")
    private List<Campus> campusList = new ArrayList<>();

    public College(String name) {
        this.name = name;
    }
}

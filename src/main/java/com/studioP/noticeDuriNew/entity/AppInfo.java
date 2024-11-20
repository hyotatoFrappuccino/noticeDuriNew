package com.studioP.noticeDuriNew.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AppInfo {

    @Id
    @GeneratedValue
    @Column(name = "app_info_id")
    private Long id;

    private String version;

    private String update_notes;

    public AppInfo(String version, String update_notes) {
        this.version = version;
        this.update_notes = update_notes;
    }
}

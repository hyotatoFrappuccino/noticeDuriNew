package com.studioP.noticeDuriNew.repository;

import com.studioP.noticeDuriNew.entity.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppInfoRepository extends JpaRepository<AppInfo, Long> {
}

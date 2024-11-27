package com.studioP.noticeDuriNew.AppInfo.repository;

import com.studioP.noticeDuriNew.AppInfo.entity.AppInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppInfoRepository extends JpaRepository<AppInfo, Long> {
}

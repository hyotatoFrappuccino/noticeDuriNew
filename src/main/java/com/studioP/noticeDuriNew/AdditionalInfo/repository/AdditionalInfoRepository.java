package com.studioP.noticeDuriNew.AdditionalInfo.repository;

import com.studioP.noticeDuriNew.AdditionalInfo.entity.AdditionalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalInfoRepository extends JpaRepository<AdditionalInfo, Long> {
}

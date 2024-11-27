package com.studioP.noticeDuriNew.Download.repository;

import com.studioP.noticeDuriNew.Download.entity.Download;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
}

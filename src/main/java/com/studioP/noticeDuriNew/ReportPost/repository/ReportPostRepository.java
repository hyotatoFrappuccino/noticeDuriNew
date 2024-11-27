package com.studioP.noticeDuriNew.ReportPost.repository;

import com.studioP.noticeDuriNew.ReportPost.entity.ReportPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportPostRepository extends JpaRepository<ReportPost, Long> {
}

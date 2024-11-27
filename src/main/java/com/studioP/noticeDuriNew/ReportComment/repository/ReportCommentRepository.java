package com.studioP.noticeDuriNew.ReportComment.repository;

import com.studioP.noticeDuriNew.ReportComment.entity.ReportComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportCommentRepository extends JpaRepository<ReportComment, Long> {
}

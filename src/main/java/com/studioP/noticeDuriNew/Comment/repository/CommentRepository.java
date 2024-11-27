package com.studioP.noticeDuriNew.Comment.repository;

import com.studioP.noticeDuriNew.Comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}

package com.studioP.noticeDuriNew.Post.repository;

import com.studioP.noticeDuriNew.Post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

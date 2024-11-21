package com.studioP.noticeDuriNew.repository;

import com.studioP.noticeDuriNew.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.studioP.noticeDuriNew.repository;

import com.studioP.noticeDuriNew.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
}

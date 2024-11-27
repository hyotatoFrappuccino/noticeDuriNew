package com.studioP.noticeDuriNew.College.repository;

import com.studioP.noticeDuriNew.College.entity.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long> {
}

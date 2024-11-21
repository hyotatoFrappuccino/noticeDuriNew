package com.studioP.noticeDuriNew.repository;

import com.studioP.noticeDuriNew.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
}

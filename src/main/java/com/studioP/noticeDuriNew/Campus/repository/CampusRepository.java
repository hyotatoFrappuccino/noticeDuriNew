package com.studioP.noticeDuriNew.Campus.repository;

import com.studioP.noticeDuriNew.Campus.entity.Campus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampusRepository extends JpaRepository<Campus, Long> {
}

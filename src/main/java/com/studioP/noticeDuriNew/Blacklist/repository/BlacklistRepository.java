package com.studioP.noticeDuriNew.Blacklist.repository;

import com.studioP.noticeDuriNew.Blacklist.entity.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlacklistRepository extends JpaRepository<Blacklist, Long> {
}

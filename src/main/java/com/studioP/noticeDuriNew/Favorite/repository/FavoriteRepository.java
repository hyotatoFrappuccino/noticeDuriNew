package com.studioP.noticeDuriNew.Favorite.repository;

import com.studioP.noticeDuriNew.Favorite.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
}

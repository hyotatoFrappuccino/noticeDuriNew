package com.studioP.noticeDuriNew.Suggestion.repository;

import com.studioP.noticeDuriNew.Suggestion.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
}

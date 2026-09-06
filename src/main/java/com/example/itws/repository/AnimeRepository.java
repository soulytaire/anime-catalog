package com.example.itws.repository;

import com.example.itws.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

    @Query("SELECT a FROM Anime a WHERE " +
            "(:title IS NULL OR LOWER(a.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:studioId IS NULL OR a.studio.id = :studioId) AND " +
            "(:minScore IS NULL OR a.score >= :minScore)")
    List<Anime> searchAnime(@Param("title") String title,
                            @Param("studioId") Long studioId,
                            @Param("minScore") Double minScore);
}
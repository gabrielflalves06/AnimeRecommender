package com.gabrielfalves.anime_recommender.Repository;

import com.gabrielfalves.anime_recommender.Entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    Optional<Anime> findByIdExterno(Long idExterno);

    boolean existsByIdExterno(Long idExterno);

    List<Anime> findByTituloContainingIgnoreCase(String titulo);
}

package com.gabrielfalves.anime_recommender.Repository;

import com.gabrielfalves.anime_recommender.Entity.Demografia;
import com.gabrielfalves.anime_recommender.Entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DemografiaRepository extends JpaRepository<Demografia, Long> {
    Optional<Demografia> findByNome(String nome);
}

package com.gabrielfalves.anime_recommender.Repository;

import com.gabrielfalves.anime_recommender.Entity.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Optional<Genero> findByNome(String nome);
}

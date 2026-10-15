package com.gabrielfalves.anime_recommender.Repository;

import com.gabrielfalves.anime_recommender.Entity.Genero;
import com.gabrielfalves.anime_recommender.Entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemaRepository extends JpaRepository<Tema, Long> {
    Optional<Tema> findByNome(String nome);
}

package com.gabrielfalves.anime_recommender.Repository;

import com.gabrielfalves.anime_recommender.Entity.Anime;
import com.gabrielfalves.anime_recommender.Entity.Genero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.AutoConfigureDataJpa;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnimeRepositoryTest {
    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Test
    void deveSalvarAnimeComGeneroEBuscarPeloIdExterno(){
        Genero acao = generoRepository.save(new Genero("Action"));
        Anime anime = new Anime(6L, "TRIGUN");
        anime.getGeneros().add(acao);

        animeRepository.saveAndFlush(anime);

        Optional<Anime> encontrado = animeRepository.findByIdExterno(6L);
        assertTrue(encontrado.isPresent());
        assertEquals("TRIGUN",encontrado.get().getTitulo());
        assertEquals(1, encontrado.get().getGeneros().size());
    }

    @Test
    void naoDevePermitirDoisAnimesComOMesmoIdExterno() {
        animeRepository.saveAndFlush(new Anime(6L, "TRIGUN"));

        assertThrows(DataIntegrityViolationException.class,
                () -> animeRepository.saveAndFlush(new Anime(6L, "OUTRO TITULO")));
    }


}

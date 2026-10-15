package com.gabrielfalves.anime_recommender.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "anime")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_externo", nullable = false, unique = true)
    private Long idExterno;

    @Column(nullable = false)
    private String titulo;

    private String imagem;

    @Column(name = "data_lancamento")
    private LocalDate datalancamento;

    private Integer nota;

    private Integer popularidade;

    private String sinopse;

    private String tipo;

    @ManyToMany
    @JoinTable(
            name = "anime_genero",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private Set<Genero> generos = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "anime_tema",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "tema_id"))
    private Set<Tema> temas = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "anime_demografia",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "demografia_id"))
    private Set<Demografia> demografias = new HashSet<>();

    public Anime(Long idExterno, String titulo) {
        this.idExterno = idExterno;
        this.titulo = titulo;
    }
}

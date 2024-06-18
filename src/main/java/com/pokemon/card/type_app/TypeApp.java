package com.pokemon.card.type_app;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pokemon.card.pokemon_app.PokemonApp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TypeApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "types")
    private List<PokemonApp> pokemons;

    @JsonIgnore
    @ManyToMany(mappedBy = "weaknesses")
    private List<PokemonApp> weaknesses;
}

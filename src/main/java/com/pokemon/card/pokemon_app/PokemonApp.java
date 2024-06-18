package com.pokemon.card.pokemon_app;

import com.pokemon.card.attack.Attack;
import com.pokemon.card.type_app.TypeApp;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PokemonApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String displayName;
    private double weight;
    private double height;
    private String description;
    private String miniDescription;
    private int hp;
    private int level;
    private Long attackId1;
    private Long attackId2;

    @ManyToOne
    @JoinColumn(name = "base_pokemon_id")
    private PokemonApp basePokemon;

    @ManyToMany
    @JoinTable(
            name = "pokemon_type",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<TypeApp> types;

    @ManyToMany
    @JoinTable(
            name = "pokemon_weakness",
            joinColumns = @JoinColumn(name = "pokemon_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id")
    )
    private List<TypeApp> weaknesses;

//    @ManyToMany
//    @JoinTable(
//            name = "pokemon_attack",
//            joinColumns = @JoinColumn(name = "pokemon_id"),
//            inverseJoinColumns = @JoinColumn(name = "type_id")
//    )
//    private List<Attack> attacks;
}

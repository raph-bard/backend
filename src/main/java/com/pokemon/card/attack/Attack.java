package com.pokemon.card.attack;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pokemon.card.pokemon_app.PokemonApp;
import com.pokemon.card.type_app.TypeApp;
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
public class Attack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int power;
    private boolean isTalent;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    @JsonIgnore
    private TypeApp type;
}

package com.pokemon.card.pokemon_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonApp, Long> {
}

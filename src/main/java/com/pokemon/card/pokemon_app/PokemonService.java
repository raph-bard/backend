package com.pokemon.card.pokemon_app;

import com.pokemon.card.attack.Attack;
import com.pokemon.card.attack.AttackRepository;
import com.pokemon.card.attack.AttackService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Autowired
    private AttackService attackService;

    public List<PokemonApp> getAll() {
        return repository.findAll();
    }

    public PokemonApp getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " cannot be found"));
    }

    public PokemonApp add(PokemonApp pokemon) {
        return repository.save(pokemon);
    }

    public PokemonApp update(PokemonApp pokemon, Long id) {
        PokemonApp existingPokemon = getById(id);
        existingPokemon.setName(pokemon.getName());
        return repository.save(existingPokemon);
    }

    public void delete(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}

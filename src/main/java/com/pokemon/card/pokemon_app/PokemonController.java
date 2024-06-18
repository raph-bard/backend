package com.pokemon.card.pokemon_app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@CrossOrigin("*")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<PokemonApp>> getAll() {
        List<PokemonApp> pokemon = service.getAll();
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PokemonApp> getById(@PathVariable Long id) {
        PokemonApp pokemon = service.getById(id);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PokemonApp> add(@RequestBody PokemonApp pokemon) {
        PokemonApp newPokemon = service.add(pokemon);
        return new ResponseEntity<>(newPokemon, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PokemonApp> update(@RequestBody PokemonApp pokemon, @PathVariable Long id) {
        PokemonApp updatedPokemon = service.update(pokemon, id);
        return new ResponseEntity<>(updatedPokemon, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

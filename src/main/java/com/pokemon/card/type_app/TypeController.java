package com.pokemon.card.type_app;

import com.pokemon.card.pokemon_app.PokemonApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<TypeApp>> getAll() {
        List<TypeApp> type = service.getAll();
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TypeApp> getById(@PathVariable Long id) {
        TypeApp type = service.getById(id);
        return new ResponseEntity<>(type, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<TypeApp> add(@RequestBody TypeApp type) {
        TypeApp newType = service.add(type);
        return new ResponseEntity<>(newType, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TypeApp> update(@RequestBody TypeApp type, @PathVariable Long id) {
        TypeApp updatedType = service.update(type, id);
        return new ResponseEntity<>(updatedType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

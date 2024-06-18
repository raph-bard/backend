package com.pokemon.card.attack;

import com.pokemon.card.type_app.TypeApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attack")
public class AttackController {

    @Autowired
    private AttackService service;

    @GetMapping("/get/all")
    public ResponseEntity<List<Attack>> getAll() {
        List<Attack> attack = service.getAll();
        return new ResponseEntity<>(attack, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Attack> getById(@PathVariable Long id) {
        Attack attack = service.getById(id);
        return new ResponseEntity<>(attack, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Attack> add(@RequestBody Attack attack) {
        Attack newAttack = service.add(attack);
        return new ResponseEntity<>(newAttack, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Attack> update(@RequestBody Attack attack, @PathVariable Long id) {
        Attack updatedAttack = service.update(attack, id);
        return new ResponseEntity<>(updatedAttack, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.pokemon.card.attack;

import com.pokemon.card.type_app.TypeApp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AttackService {

    @Autowired
    private AttackRepository repository;

    public List<Attack> getAll() {
        return repository.findAll();
    }

    public Attack getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " cannot be found"));
    }

    public Attack add(Attack attack) {
        return repository.save(attack);
    }

    public Attack update(Attack attack, Long id) {
        Attack existingAttack = getById(id);
        existingAttack.setName(attack.getName());
        return repository.save(existingAttack);
    }

    public void delete(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}



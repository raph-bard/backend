package com.pokemon.card.type_app;

import com.pokemon.card.pokemon_app.PokemonApp;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public List<TypeApp> getAll() {
        return repository.findAll();
    }

    public TypeApp getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Entity with id " + id + " cannot be found"));
    }

    public TypeApp add(TypeApp type) {
        return repository.save(type);
    }

    public TypeApp update(TypeApp type, Long id) {
        TypeApp existingType = getById(id);
        existingType.setName(type.getName());
        return repository.save(existingType);
    }

    public void delete(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException();
        }
    }
}

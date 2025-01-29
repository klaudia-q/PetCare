package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Animal;
import com.pracazaliczeniowa.pracazaliczeniowa.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {
    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }
}

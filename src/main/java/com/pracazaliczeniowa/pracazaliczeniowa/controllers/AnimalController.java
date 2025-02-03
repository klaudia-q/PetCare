package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.DTO.AnimalDTO;
import com.pracazaliczeniowa.pracazaliczeniowa.services.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequiredArgsConstructor
public class AnimalController {

    private final String BASE_PATH = "/api/animal";
    private final String PATH_ID = "/api/animal/{animalId}";
    private final String GET_CLIENT_ANIMALS_PATH = "/api/animal/byClient/{clientId}";
    private final String GET_OTHER_CLIENT_ANIMALS_PATH = "/api/animal/clientOtherAnimals/{animalId}";


    private final AnimalService animalService;

    @GetMapping(PATH_ID)
    public AnimalDTO getAnimalById(@PathVariable("animalId") Long animalId) {
        return animalService.getAnimalById(animalId);
    }

    @PostMapping(BASE_PATH)
    public AnimalDTO createNewAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.createNewAnimal(animalDTO);
    }

    @PatchMapping(BASE_PATH)
    public ResponseEntity<String> updateAnimal(@RequestBody AnimalDTO animalDTO) {
        boolean updated = animalService.updateAnimal(animalDTO);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(PATH_ID)
    public ResponseEntity<String> deleteAnimalById(@PathVariable("animalId") Long animalId) {
        animalService.deleteAnimalById(animalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(GET_OTHER_CLIENT_ANIMALS_PATH)
    public Set<AnimalDTO> findOtherAnimalsWithSameOwner(@PathVariable("animalId") Long animalId) {
        return animalService.findOtherAnimalsWithSameOwner(animalId);
    }

    @GetMapping(GET_CLIENT_ANIMALS_PATH)
    public Set<AnimalDTO> getAnimalsByClient(@PathVariable("clientId") Long clientId) {
        return animalService.getAnimalsByClient(clientId);
    }

}

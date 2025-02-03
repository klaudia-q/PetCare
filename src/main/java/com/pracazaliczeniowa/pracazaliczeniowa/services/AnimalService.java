package com.pracazaliczeniowa.pracazaliczeniowa.services;

import com.pracazaliczeniowa.pracazaliczeniowa.model.DTO.AnimalDTO;

import java.util.Set;

public interface AnimalService {
    AnimalDTO getAnimalById(Long animalId);
    AnimalDTO createNewAnimal(AnimalDTO animalDTO);
    boolean updateAnimal(AnimalDTO animalDTO);
    void deleteAnimalById(Long id);
    Set<AnimalDTO> findOtherAnimalsWithSameOwner(Long animalId);
    Set<AnimalDTO> getAnimalsByClient(Long clientId);

}

package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.DTO.AnimalDTO;
import com.pracazaliczeniowa.pracazaliczeniowa.services.AnimalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//Kontroler obsługujący operacje związane ze zwierzętami.

@RestController
@Tag(name = "Animals", description = "API for managing animals")
@RequiredArgsConstructor
public class AnimalController {

//Ścieżki dla endpointów
    private final String BASE_PATH = "/api/animal";
    private final String PATH_ID = "/api/animal/{animalId}";
    private final String GET_CLIENT_ANIMALS_PATH = "/api/animal/byClient/{clientId}";
    private final String GET_OTHER_CLIENT_ANIMALS_PATH = "/api/animal/clientOtherAnimals/{animalId}";
    private final AnimalService animalService;

//Pobiera informacje o zwierzęciu na podstawie jego ID.

    @Operation(
            summary = "Get animal by ID",
            description = "Retrieve details of a specific animal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Animal found",
                            content = @Content(schema = @Schema(implementation = AnimalDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Animal not found")
            }
    )
    @GetMapping(PATH_ID)
    public AnimalDTO getAnimalById(@PathVariable("animalId") Long animalId) {
        return animalService.getAnimalById(animalId);
    }

//Tworzenie nowego zwierzęcia
    @Operation(
            summary = "Create a new animal",
            description = "Adds a new animal to the database",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Animal created",
                            content = @Content(schema = @Schema(implementation = AnimalDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request")
            }
    )
    @PostMapping(BASE_PATH)
    public AnimalDTO createNewAnimal(@RequestBody AnimalDTO animalDTO) {
        return animalService.createNewAnimal(animalDTO);
    }

//Aktualizowanie zwierzęcia
    @Operation(
            summary = "Update an existing animal",
            description = "Updates the details of an existing animal",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Animal updated"),
                    @ApiResponse(responseCode = "400", description = "Invalid request")
            }
    )
    @PatchMapping(BASE_PATH)
    public ResponseEntity<String> updateAnimal(@RequestBody AnimalDTO animalDTO) {
        boolean updated = animalService.updateAnimal(animalDTO);
        if (updated) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

//Usuwanie zwierzęcia na podstawie jego ID
    @Operation(
            summary = "Delete animal by ID",
            description = "Removes an animal from the database",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Animal deleted"),
                    @ApiResponse(responseCode = "404", description = "Animal not found")
            }
    )
    @DeleteMapping(PATH_ID)
    public ResponseEntity<String> deleteAnimalById(@PathVariable("animalId") Long animalId) {
        animalService.deleteAnimalById(animalId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//Pobiera wszystkie zwierzęta należące do tego samego właściciela, z wyjątkiem podanego.

    @Operation(
            summary = "Find other animals of the same owner",
            description = "Retrieves all animals owned by the same client except the given one",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Animals retrieved",
                            content = @Content(schema = @Schema(implementation = AnimalDTO.class))),
                    @ApiResponse(responseCode = "404", description = "No animals found")
            }
    )
    @GetMapping(GET_OTHER_CLIENT_ANIMALS_PATH)
    public Set<AnimalDTO> findOtherAnimalsWithSameOwner(@PathVariable("animalId") Long animalId) {
        return animalService.findOtherAnimalsWithSameOwner(animalId);
    }

//Pobiera wszystkie zwierzęta przypisane do konkretnego klienta.

    @Operation(
            summary = "Get animals by client ID",
            description = "Retrieves all animals associated with a specific client",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Animals retrieved",
                            content = @Content(schema = @Schema(implementation = AnimalDTO.class))),
                    @ApiResponse(responseCode = "404", description = "No animals found")
            }
    )
    @GetMapping(GET_CLIENT_ANIMALS_PATH)
    public Set<AnimalDTO> getAnimalsByClient(@PathVariable("clientId") Long clientId) {
        return animalService.getAnimalsByClient(clientId);
    }
}

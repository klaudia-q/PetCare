package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Box;
import com.pracazaliczeniowa.pracazaliczeniowa.repositories.BoxRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxes") // Główna ścieżka dla kontrolera
@Tag(name = "Boxes", description = "API for managing storage boxes")
public class BoxController {

    @Autowired
    private BoxRepository boxRepository; // Wstrzykiwanie zależności do repozytorium

    //Endpoint do pobierania wszystkich boxów
    @Operation(
            summary = "Get all boxes", // Krótkie podsumowanie operacji
            description = "Retrieves a list of all boxes", // Opis operacji
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of boxes retrieved successfully",
                            content = @Content(schema = @Schema(implementation = Box.class))) // Odpowiedź w przypadku powodzenia
            }
    )
    @GetMapping // Ścieżka do pobierania danych (GET)
    public List<Box> getAllBoxes() {
        return boxRepository.findAll(); // Zwracamy wszystkie boxy z repozytorium
    }

    //Endpoint do tworzenia nowego boxa
    @Operation(
            summary = "Create a new box", // Krótkie podsumowanie operacji
            description = "Adds a new box to the database", // Opis operacji
            responses = {
                    @ApiResponse(responseCode = "201", description = "Box created successfully",
                            content = @Content(schema = @Schema(implementation = Box.class))), // Odpowiedź w przypadku powodzenia
                    @ApiResponse(responseCode = "400", description = "Invalid request") // Odpowiedź w przypadku błędu w żądaniu
            }
    )
    @PostMapping //Scieżka do tworzenia nowego zasobu (POST)
    public Box createBox(@RequestBody Box box) {
        return boxRepository.save(box); // Zapisujemy nowe boxy w repozytorium
    }
}


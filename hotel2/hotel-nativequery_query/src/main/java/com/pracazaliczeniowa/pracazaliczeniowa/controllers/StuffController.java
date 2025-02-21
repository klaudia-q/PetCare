package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Stuff;
import com.pracazaliczeniowa.pracazaliczeniowa.repositories.StuffRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stuff") // Główna ścieżka dla kontrolera
@Tag(name = "Stuff", description = "API for managing stuff") // Opis kontrolera w Swaggerze
public class StuffController {

    @Autowired
    private StuffRepository stuffRepository; // Wstrzykiwanie zależności do repozytorium rzeczy

    //Endpoint do pobierania wszystkich z personelu
    @Operation(
            summary = "Get all stuff",
            description = "Retrieves a list of all stuff",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of stuff retrieved successfully",
                            content = @Content(schema = @Schema(implementation = Stuff.class)))
            }
    )
    @GetMapping // Ścieżka do pobierania wszystkich pracowników
    public List<Stuff> getAllStuff() {
        return stuffRepository.findAll();
    }

    //Endpoint do tworzenia nowej osoby z personelu
    @Operation(
            summary = "Create new stuff",
            description = "Adds a new item to the stuff repository",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Stuff created successfully",
                            content = @Content(schema = @Schema(implementation = Stuff.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping // Ścieżka do tworzenia nowej osoby z personelu
    public Stuff createStuff(@RequestBody Stuff stuff) {
        return stuffRepository.save(stuff);
    }
}

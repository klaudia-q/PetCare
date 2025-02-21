package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import com.pracazaliczeniowa.pracazaliczeniowa.services.ClientServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client") // główna ścieżka kontrolera
@Tag(name = "Clients", description = "API for managing clients")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    // Pobieranie wszystkich klientów
    @Operation(
            summary = "Get all clients",
            description = "Retrieves a list of all clients",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of clients retrieved successfully",
                            content = @Content(schema = @Schema(implementation = Client.class)))
            }
    )
    @GetMapping("/ALL") // Ścieżka do pobierania wszystkich klientów
    public List<Client> getAllClients() {
        return clientService.getAllClients(); // Zwracamy wszystkich klientów z serwisu
    }

    //Endpoint do pobierania liczby wizyt dla konkretnego klienta
    @Operation(
            summary = "Get visit count for a client",
            description = "Retrieves the number of visits for a specific client",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Visit count retrieved successfully"),
                    @ApiResponse(responseCode = "404", description = "Client not found")
            }
    )
    @GetMapping("/{clientId}/visitsCount")
    public Long getClientVisitsCount(@PathVariable Long clientId) {
 // Zwracamy liczbę wizyt klienta na podstawie jego ID
        return clientService.getClientCount();
    }
}

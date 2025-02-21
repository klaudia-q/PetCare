package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Service;

import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ServiceRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
@Tag(name = "Services", description = "API for managing services")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;

    //Endpoint do pobierania wszystkich usług

    @Operation(
            summary = "Get all services",
            description = "Retrieves a list of all available services",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of services retrieved successfully",
                            content = @Content(schema = @Schema(implementation = Service.class)))
            }
    )
    @GetMapping // Ścieżka do pobierania wszystkich usług
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }

    //Endpoint do tworzenia nowej usługi

    @Operation(
            summary = "Create a new service",
            description = "Adds a new service to the system",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Service created successfully",
                            content = @Content(schema = @Schema(implementation = Service.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping // Ścieżka do tworzenia nowej usługi
    public Service createService(@RequestBody Service service) {
        return serviceRepository.save(service);
    }
}

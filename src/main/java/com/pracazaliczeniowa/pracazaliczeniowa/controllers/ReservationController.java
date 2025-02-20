package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Reservation;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ReservationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations") // Główna ścieżka dla kontrolera
@Tag(name = "Reservations", description = "API for managing reservations") // Opis kontrolera w Swaggerze
public class ReservationController {

    @Autowired
    private ReservationRepository reservationRepository; // Wstrzykiwanie zależności do repozytorium rezerwacji

    //Endpoint do pobierania wszystkich rezerwacji

    @Operation(
            summary = "Get all reservations",
            description = "Retrieves a list of all reservations",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of reservations retrieved successfully",
                            content = @Content(schema = @Schema(implementation = Reservation.class)))
            }
    )
    @GetMapping // Ścieżka do pobierania wszystkich rezerwacji
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll(); // Zwracamy wszystkie rezerwacje z repozytorium
    }

    //Endpoint do tworzenia nowej rezerwacji
    @Operation(
            summary = "Create a new reservation",
            description = "Adds a new reservation to the system",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Reservation created successfully",
                            content = @Content(schema = @Schema(implementation = Reservation.class))),
                    @ApiResponse(responseCode = "400", description = "Invalid request data")
            }
    )
    @PostMapping // Ścieżka do tworzenia nowej rezerwacji
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}

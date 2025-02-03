package com.pracazaliczeniowa.pracazaliczeniowa.controllers;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Reservation;
import com.pracazaliczeniowa.pracazaliczeniowa.repositores.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}

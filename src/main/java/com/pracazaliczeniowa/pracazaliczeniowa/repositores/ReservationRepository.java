package com.pracazaliczeniowa.pracazaliczeniowa.repositories;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

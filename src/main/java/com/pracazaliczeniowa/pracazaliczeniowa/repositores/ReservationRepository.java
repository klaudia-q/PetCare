package com.pracazaliczeniowa.pracazaliczeniowa.repositores;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

//Pobieranie wszystkich rezerwacji
    @Query("SELECT r FROM Reservation r")
    List<Reservation> findAllReservations();

    @NativeQuery (value = "SELECT * FROM Reservation")
    List<Reservation> findAllReservationsNative();

//Pobieranie rezerwacji dla klienta

    @NativeQuery (value = "SELECT * FROM Reservation WHERE client_id = :clientId")
    List<Reservation> findReservationsByClientNative(@Param("clientId") Long clientId);

}
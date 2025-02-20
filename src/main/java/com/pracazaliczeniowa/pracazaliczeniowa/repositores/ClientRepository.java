package com.pracazaliczeniowa.pracazaliczeniowa.repositores;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT COUNT(c) FROM Client c") // JPQL – Liczenie klientów
    long countClients();

    List<Client> findAllByEmailContaining(String emailPart);
}
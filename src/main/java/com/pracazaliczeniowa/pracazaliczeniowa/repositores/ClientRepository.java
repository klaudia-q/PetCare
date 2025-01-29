package com.pracazaliczeniowa.pracazaliczeniowa.repositores;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository <Client, Long> {
}



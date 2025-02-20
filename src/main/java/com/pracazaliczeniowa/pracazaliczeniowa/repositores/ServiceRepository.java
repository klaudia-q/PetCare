package com.pracazaliczeniowa.pracazaliczeniowa.repositories;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Service;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    // Pobieranie wszystkich usług - JPQL Query
    @Query("SELECT s FROM Service s")
    List<Service> findAllServicesJPQL();

    // Pobieranie wszystkich usług - Native Query
    @NativeQuery(value = "SELECT * FROM service")
    List<Service> findAllServicesNative();

}


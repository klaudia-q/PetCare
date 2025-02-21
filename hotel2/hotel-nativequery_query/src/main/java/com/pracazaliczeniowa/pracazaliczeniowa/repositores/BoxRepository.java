package com.pracazaliczeniowa.pracazaliczeniowa.repositories;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoxRepository extends JpaRepository<Box, Long> {


    // **JPQL Query**
    @Query("SELECT b FROM Box b")
    List<Box> findAllBoxesJPQL();

    // **Native Query**
    @Query(value = "SELECT * FROM box", nativeQuery = true)
    List<Box> findAllBoxesNative();

}
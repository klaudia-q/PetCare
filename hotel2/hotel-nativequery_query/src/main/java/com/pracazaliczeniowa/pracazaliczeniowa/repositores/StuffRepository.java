package com.pracazaliczeniowa.pracazaliczeniowa.repositories;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StuffRepository extends JpaRepository<Stuff, Long> {

// Tworzenie nowego pracownika

//Query
    @Query("INSERT INTO Stuff (name, lastName, role) VALUES (:name, :lastName, :role)")
    void createStuff(@Param("name") String name, @Param("lastName") String lastName, @Param("role") String role);

    //NativeQuery
    @NativeQuery(value = "INSERT INTO Stuff (name, last_name, role) VALUES (:name, :lastName, :role)")
    void createStuffNative(@Param("name") String name, @Param("lastName") String lastName, @Param("role") String role);


}

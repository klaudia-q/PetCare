package com.pracazaliczeniowa.pracazaliczeniowa.repositores;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // JPQL: Pobiera wszystkie zwierzęta tego samego właściciela
    @Query("SELECT a FROM Animal a WHERE a.klient = (SELECT an.klient FROM Animal an WHERE an.id = :animalId)")
    Set<Animal> findOtherAnimalsWithSameOwner(@Param("animalId") Long animalId);

    // Native Query: Pobiera zwierzęta po clientId
    @Query(value = "SELECT * FROM animal a WHERE a.client_id = :clientId", nativeQuery = true)
    Set<Animal> getAnimalsByClientNative(@Param("clientId") Long clientId);
}

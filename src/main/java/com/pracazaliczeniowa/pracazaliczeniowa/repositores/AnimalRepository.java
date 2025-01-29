package com.pracazaliczeniowa.pracazaliczeniowa.repositories;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}

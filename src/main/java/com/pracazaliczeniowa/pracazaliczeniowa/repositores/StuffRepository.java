package com.pracazaliczeniowa.pracazaliczeniowa.repositories;

import com.pracazaliczeniowa.pracazaliczeniowa.model.Stuff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuffRepository extends JpaRepository<Stuff, Long> {
}

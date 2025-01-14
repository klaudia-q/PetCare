package com.pracazaliczeniowa.pracazaliczeniowa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imie;
    private String nazwisko;
    private String email;

    @OneToMany(mappedBy = "klient", cascade = CascadeType.ALL)
    private List<Animal> zwierzeta;

    // Gettery, settery, konstruktor
}

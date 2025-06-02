package com.pracazaliczeniowa.pracazaliczeniowa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imie;
    private String gatunek;
    private String rasa;
    private int wiek;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client klient;

    // Gettery, settery, konstruktor
}

public class AnimalStay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    

}
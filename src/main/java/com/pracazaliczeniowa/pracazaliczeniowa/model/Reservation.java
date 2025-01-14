package com.pracazaliczeniowa.pracazaliczeniowa.model;

import jakarta.persistence.*;
import lombok.Data;


import javax.swing.*;
import java.util.List;

@Data
@Entity
class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client klient;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal zwierze;

    @ManyToMany
    @JoinTable(
            name = "reservation_service",
            joinColumns = @JoinColumn(name = "reservation_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private List<Service> service;

    @ManyToOne
    @JoinColumn(name = "boks_id")
    private Box box;

    private String term;

}

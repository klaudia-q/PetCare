package com.pracazaliczeniowa.pracazaliczeniowa.model.DTO;

import lombok.Data;

@Data
public class AnimalDTO {

    private Long id;
    private String imie;
    private String gatunek;
    private String rasa;
    private int wiek;
    private Long idKlienta;
}

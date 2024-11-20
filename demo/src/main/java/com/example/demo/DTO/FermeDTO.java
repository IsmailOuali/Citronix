package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

public class FermeDTO {

    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private String nom;

    @Getter
    @Setter
    private String localisation;

    @Getter
    @Setter
    private double superficie;

    @Getter
    @Setter
    private LocalDate dateCreation;

    public FermeDTO() {}

    public FermeDTO(UUID id,String nom, String localisation, double superficie, LocalDate dateCreation) {
        this.id = id;
        this.nom = nom;
        this.localisation = localisation;
        this.superficie = superficie;
        this.dateCreation = dateCreation;
    }


}

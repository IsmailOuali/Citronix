package com.example.demo.DTO.Ferme;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FermeResponseDTO {
    private UUID id;

    private String nom;

    private String localisation;

    private double superficie;

    private LocalDate dateCreation;

}

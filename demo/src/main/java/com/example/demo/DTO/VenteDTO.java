package com.example.demo.DTO;

import com.example.demo.model.Recolte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteDTO {

    private UUID id;

    private LocalDate date;

    private double prixUnitaire;

    private double quantite;

    private double revenu;

    private Recolte recolte;

    private String client;
}

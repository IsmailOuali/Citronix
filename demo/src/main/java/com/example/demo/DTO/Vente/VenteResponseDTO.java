package com.example.demo.DTO.Vente;

import com.example.demo.model.Recolte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteResponseDTO {

    private UUID id;

    private LocalDate date;

    private double prixUnitaire;

    private double quantite;

    private double revenu;

    private Recolte recolte;

    private String client;
}

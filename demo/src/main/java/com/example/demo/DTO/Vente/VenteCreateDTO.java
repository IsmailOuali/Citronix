package com.example.demo.DTO.Vente;

import com.example.demo.model.Recolte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteCreateDTO implements Serializable {

    private LocalDate date;

    private double prixUnitaire;

    private double quantite;

    private double revenu;

    private Recolte recolte;

    private String client;
}

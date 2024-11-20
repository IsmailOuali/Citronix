package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private LocalDate date;

    private double prixUnitaire;

    private double quantite;

    private double revenu;

    @ManyToOne
    @JoinColumn(name = "recolte_id")
    private Recolte recolte;

    private String client;
}

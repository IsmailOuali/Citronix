package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Vente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private double prixUnitaire;

    private double quantite;

    private double revenu;

    @ManyToOne
    @JoinColumn(name = "recolte_id")
    private Recolte recolte;

    private String client;
}

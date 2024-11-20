package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class DetailRecolte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double quantiteRecoltee;

    @ManyToOne
    @JoinColumn(name = "arbre_id")
    private Arbre arbre;

    @ManyToOne
    @JoinColumn(name = "recolte_id")
    private Recolte recolte;
}

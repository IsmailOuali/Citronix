package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class DetailRecolte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double quantiteRecoltee;

    @ManyToOne
    @JoinColumn(name = "arbre_id")
    private Arbre arbre;

    @ManyToOne
    @JoinColumn(name = "recolte_id")
    private Recolte recolte;
}

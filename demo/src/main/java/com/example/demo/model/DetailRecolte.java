package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class DetailRecolte {

    @EmbeddedId
    private DetailRecolteId id;

    private double quantiteRecoltee;

    @ManyToOne
    @MapsId("arbreId")
    @JoinColumn(name = "arbre_id")
    private Arbre arbre;

    @ManyToOne
    @MapsId("recolteId")
    @JoinColumn(name = "recolte_id")
    private Recolte recolte;
}

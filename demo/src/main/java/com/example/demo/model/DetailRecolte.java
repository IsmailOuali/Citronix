package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class DetailRecolte {

    @EmbeddedId
    private DetailRecolteId id;

    @Column(name = "id", nullable = false, unique = true)
    private UUID detailRecolte_id; //

    private double quantiteRecoltee;

    @ManyToOne
    @MapsId("arbreId")
    @JoinColumn(name = "arbre_id", nullable = false)
    private Arbre arbre;

    @ManyToOne
    @MapsId("recolteId")
    @JoinColumn(name = "recolte_id", nullable = false)
    private Recolte recolte;
}

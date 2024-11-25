package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Champ {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private double superficie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ferme_id")
    private Ferme ferme;

    @OneToMany(mappedBy = "champ", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Arbre> arbres;
}
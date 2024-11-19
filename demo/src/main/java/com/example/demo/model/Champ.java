package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Champ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private double superficie;

//    @ManyToOne
//    @JoinColumn(name = "ferme_id")
//    private Ferme ferme;
//
//    @OneToMany(mappedBy = "champ", cascade = CascadeType.ALL)
//    private List<Arbre> arbres;
}
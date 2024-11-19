package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Ferme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String nom;

    private String localisation;

    private double superficie;

    private LocalDate dateCreation;

//    @OneToMany(mappedBy = "arbre", cascade = CascadeType.ALL)
//    private List<Champ> champs;
}

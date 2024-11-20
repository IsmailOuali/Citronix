package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "ferme")
public class Ferme {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String nom;

    private String localisation;

    private double superficie;

    private LocalDate dateCreation;

    @OneToMany(mappedBy = "ferme", cascade = CascadeType.ALL)
    private List<Champ> champs;
}

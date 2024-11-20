package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Arbre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private LocalDate datePlantation;

    private int age;

    @ManyToOne
    @JoinColumn(name = "champ_id")
    private Champ champ;
}


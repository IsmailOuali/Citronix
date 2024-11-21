package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Arbre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private LocalDate datePlantation;

    @Column(nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "champ_id")
    private Champ champ;
}


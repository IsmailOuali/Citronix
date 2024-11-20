package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Recolte {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String saison;

    private LocalDate dateRecolte;

    private double quantiteTotale;

    @OneToMany(mappedBy = "recolte", cascade = CascadeType.ALL)
    private List<DetailRecolte> detailsRecolte;
}

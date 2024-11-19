package com.example.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Recolte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String saison;

    private LocalDate dateRecolte;

    private double quantiteTotale;

    @OneToMany(mappedBy = "recolte", cascade = CascadeType.ALL)
    private List<DetailRecolte> detailsRecolte;
}

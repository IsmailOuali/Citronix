package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Recolte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String saison;

    private LocalDate dateRecolte;

    private double quantiteTotale;

//    @OneToMany(mappedBy = "recolte", cascade = CascadeType.ALL)
//    private List<DetailRecolte> detailsRecolte;
}

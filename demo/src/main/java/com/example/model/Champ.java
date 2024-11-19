package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import com.example.model.Arbre;

import java.util.List;

@Data
@Entity
public class Champ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double superficie;

    @ManyToOne
    @JoinColumn(name = "ferme_id")
    private Ferme ferme;

    @OneToMany(mappedBy = "champ", cascade = CascadeType.ALL)
    private List<Arbre> arbres;
}
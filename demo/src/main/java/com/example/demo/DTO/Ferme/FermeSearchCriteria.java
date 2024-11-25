package com.example.demo.DTO.Ferme;

import lombok.Data;

@Data
public class FermeSearchCriteria {
    private String nom;
    private String localisation;
    private Double minSuperficie;
    private Double maxSuperficie;
}

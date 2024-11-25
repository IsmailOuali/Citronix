package com.example.demo.DTO.DetailRecolte;

import com.example.demo.model.Arbre;
import com.example.demo.model.Recolte;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailRecolteCreateDTO {

    private double quantiteRecoltee;

    @JsonProperty("arbre")
    private Arbre arbre;

    @JsonProperty("recolte")
    private Recolte recolte;
}

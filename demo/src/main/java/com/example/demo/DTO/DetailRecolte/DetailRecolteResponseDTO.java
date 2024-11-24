package com.example.demo.DTO.DetailRecolte;

import com.example.demo.model.Arbre;
import com.example.demo.model.DetailRecolteId;
import com.example.demo.model.Recolte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailRecolteResponseDTO {
    private DetailRecolteId id;

    private double quantiteRecoltee;


    private Arbre arbre;


    private Recolte recolte;
}

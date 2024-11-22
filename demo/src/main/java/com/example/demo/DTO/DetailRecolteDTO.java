package com.example.demo.DTO;

import com.example.demo.model.Arbre;
import com.example.demo.model.DetailRecolteId;
import com.example.demo.model.Recolte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailRecolteDTO {


    private DetailRecolteId id;

    private double quantiteRecoltee;


    private Arbre arbre;


    private Recolte recolte;
}

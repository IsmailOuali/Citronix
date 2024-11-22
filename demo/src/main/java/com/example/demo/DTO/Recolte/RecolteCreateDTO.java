package com.example.demo.DTO.Recolte;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecolteCreateDTO {

    private String saison;

    private LocalDate dateRecolte;

    private double quantiteTotale;

}

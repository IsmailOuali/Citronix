package com.example.demo.DTO.Champ;

import com.example.demo.model.Ferme;

import com.example.demo.validation.ValidChampSuperficie.ValidChampSuperficie;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidChampSuperficie
public class ChampCreateDTO {

    @Min(1000)
    private double superficie;

    private Ferme ferme;
}

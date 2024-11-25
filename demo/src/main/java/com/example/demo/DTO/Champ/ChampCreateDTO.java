package com.example.demo.DTO.Champ;

import com.example.demo.model.Ferme;

import com.example.demo.validation.ValidChampSuperficie;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ValidChampSuperficie
public class ChampCreateDTO {

    @Min(1000)
    private double superficie;

    @NotNull(message = "Id s'il vous plaitt")
    private UUID fermeId;
}

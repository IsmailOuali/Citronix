package com.example.demo.DTO.Arbre;

import com.example.demo.model.Champ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArbreResponseDTO {
    private UUID id;

    private LocalDate datePlantation;

    private int age;


    private Champ champ;
}

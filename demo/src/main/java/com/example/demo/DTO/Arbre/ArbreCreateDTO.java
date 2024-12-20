package com.example.demo.DTO.Arbre;

import com.example.demo.model.Champ;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArbreCreateDTO {

    private LocalDate datePlantation;

    private int age;

    private Champ champ;
}

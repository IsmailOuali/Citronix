package com.example.demo.DTO.Arbre;

import com.example.demo.model.Champ;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  ArbreCreateDTO {

    private LocalDate datePlantation;

    private int age;

    private Champ champ;
}

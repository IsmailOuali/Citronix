package com.example.demo.DTO.Arbre;

import com.example.demo.model.Champ;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class  ArbreCreateDTO {

    private LocalDate datePlantation;

    private int age;

    private Champ champ;
}

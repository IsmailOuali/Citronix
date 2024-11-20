package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

public class ArbreDTO {

    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private LocalDate datePlantation;

    @Getter
    @Setter
    private int age;

    @Getter
    @Setter
    private ChampDTO champ;

    public ArbreDTO() {}
    public ArbreDTO(UUID id, LocalDate datePlantation, int age, ChampDTO champ) {
        this.id = id;
        this.datePlantation = datePlantation;
        this.age = age;
        this.champ = champ;
    }
}

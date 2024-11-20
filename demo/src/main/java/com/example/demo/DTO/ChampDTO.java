package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class ChampDTO {

    @Getter
    @Setter
    private UUID id;

    @Getter
    @Setter
    private double superficie;

    @Getter
    @Setter
    private FermeDTO ferme;

    @Getter
    @Setter
    private List<ArbreDTO> arbre;

    public ChampDTO() {}

    public ChampDTO(UUID id,double superficie, FermeDTO ferme , List<ArbreDTO> arbre) {
        this.id = id;
        this.superficie = superficie;
        this.ferme = ferme;
        this.arbre = arbre;
    }

}

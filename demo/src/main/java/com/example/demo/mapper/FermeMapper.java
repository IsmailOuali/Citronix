package com.example.demo.mapper;


import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Ferme;

public class FermeMapper {
    public static Ferme toEntity(FermeDTO fermDTO) {
        Ferme ferme = new Ferme();
        ferme.setNom(fermDTO.getNom());
        ferme.setLocalisation(fermDTO.getLocalisation());
        return ferme;
    }

    public static FermeDTO toDTO(Ferme ferme) {
        FermeDTO fermeDTO = new FermeDTO();
        fermeDTO.setNom(ferme.getNom());
        fermeDTO.setLocalisation(ferme.getLocalisation());
        return fermeDTO;
    }
}

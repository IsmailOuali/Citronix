package com.example.demo.service;

import com.example.demo.DTO.Ferme.FermeCreateDTO;
import com.example.demo.DTO.Ferme.FermeResponseDTO;
import com.example.demo.DTO.Ferme.FermeSearchCriteria;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Ferme;

import java.util.List;
import java.util.UUID;

public interface FermeService {
    FermeResponseDTO addFerme(FermeCreateDTO fermeCreateDTO);
    FermeDTO updateFerme(Ferme ferme);
    void deleteFermeById(UUID ferme);
    FermeDTO getFermeById(UUID id);
    List<FermeDTO> getAllFermes();
    List<FermeResponseDTO> searchFermes(FermeSearchCriteria fermeSearchCriteria);
}

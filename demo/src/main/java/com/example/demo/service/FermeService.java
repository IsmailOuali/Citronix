package com.example.demo.service;

import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Ferme;

import java.util.List;
import java.util.UUID;

public interface FermeService {
    FermeDTO addFerme(Ferme ferme);
    FermeDTO updateFerme(Ferme ferme);
    void deleteFermeById(UUID ferme);
    FermeDTO getFermeById(UUID id);
    List<FermeDTO> getAllFermes();
}

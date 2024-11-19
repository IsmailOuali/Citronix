package com.example.demo.service;

import com.example.demo.model.Ferme;

import java.util.List;
import java.util.UUID;

public interface fermeService {
    Ferme addFerme(Ferme ferme);
    Ferme updateFerme(UUID fermeId, Ferme ferme);
    void deleteFermeById(UUID ferme);
    Ferme getFermeById(UUID id);
    List<Ferme> getAllFermes();
}

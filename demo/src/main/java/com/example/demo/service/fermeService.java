package com.example.demo.service;

import com.example.demo.model.Ferme;

import java.util.UUID;

public interface fermeService {
    Ferme addFerme(Ferme ferme);
    Ferme updateFerme(Ferme ferme);
    void deleteFermeById(UUID ferme);
}

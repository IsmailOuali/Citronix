package com.example.demo.service;

import com.example.demo.model.Champ;

import java.util.List;
import java.util.UUID;

public interface ChampService {
    Champ addChamp(UUID fermeId, Champ champ);
    Champ updateChamp(Champ champ);
    void deleteChampById(UUID id);
    Champ getChampById(UUID id);
    List<Champ> getAllChamps();
}

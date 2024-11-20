package com.example.demo.service;

import com.example.demo.DTO.ChampDTO;
import com.example.demo.mapper.ChampMapper;
import com.example.demo.model.Champ;

import java.util.List;
import java.util.UUID;

public interface ChampService{
    ChampDTO addChamp(UUID fermeId, ChampDTO champDTO);
    ChampDTO updateChamp(ChampDTO champDTO);
    void deleteChampById(UUID id);
    ChampDTO getChampById(UUID id);
    List<ChampDTO> getAllChamps();
}

package com.example.demo.service;

import com.example.demo.DTO.Champ.ChampCreateDTO;
import com.example.demo.DTO.Champ.ChampResponseDTO;
import com.example.demo.DTO.ChampDTO;
import com.example.demo.mapper.ChampMapper;
import com.example.demo.model.Champ;

import java.util.List;
import java.util.UUID;

public interface ChampService{
    ChampResponseDTO addChamp(UUID fermeId, ChampCreateDTO champCreateDTO);
    ChampDTO updateChamp(ChampDTO champDTO);
    void deleteChampById(UUID id);
    ChampResponseDTO getChampById(UUID id);
    List<ChampDTO> getAllChamps();
    ChampDTO mapToDto(Champ champ);
}

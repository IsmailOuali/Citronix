package com.example.demo.service;

import com.example.demo.DTO.ChampDTO;
import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.DTO.RecolteDTO;
import com.example.demo.model.Recolte;

import java.util.List;
import java.util.UUID;

public interface RecolteService {

    RecolteResponseDTO addRecolte (UUID champ, RecolteCreateDTO recolteCreateDTO);
    RecolteDTO updateRecolte (Recolte recolte);
    void deleteRecolte (UUID recolteId);
    RecolteResponseDTO getRecolteById(UUID id);
    List<RecolteResponseDTO> getAllRecolte();
}

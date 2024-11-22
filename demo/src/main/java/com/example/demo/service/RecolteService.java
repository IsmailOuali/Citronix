package com.example.demo.service;

import com.example.demo.DTO.ChampDTO;
import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.DTO.RecolteDTO;
import com.example.demo.model.Recolte;

import java.util.List;
import java.util.UUID;

public interface RecolteService {

    RecolteResponseDTO addRecolte (RecolteCreateDTO recolteCreateDTO);
    RecolteDTO updateRecolte (RecolteDTO recolteDTO);
    void deleteRecolte (UUID recolteId);
    RecolteDTO getRecolteById(UUID id);
    List<RecolteResponseDTO> getAllRecolte();
}

package com.example.demo.service;

import com.example.demo.DTO.Vente.VenteCreateDTO;
import com.example.demo.DTO.Vente.VenteResponseDTO;

import java.util.List;
import java.util.UUID;

public interface VenteService {
    VenteResponseDTO createVente(UUID recolteId, VenteCreateDTO venteCreateDTO);
    VenteResponseDTO updateVente(VenteCreateDTO venteCreateDTO);
    void deleteVente(UUID id);
    List<VenteResponseDTO> getAllVentes();
    VenteResponseDTO getVenteById(UUID id);
}

package com.example.demo.service;

import com.example.demo.DTO.ArbreDTO;
import java.util.List;
import java.util.UUID;

public interface ArbreService {

    ArbreDTO addArbre(ArbreDTO arbreDTO);
    ArbreDTO updateArbre(UUID id, ArbreDTO arbreDTO);
    ArbreDTO getArbreById(UUID id);
    List<ArbreDTO> getAllArbres();
    void deleteArbreById(UUID id);
}

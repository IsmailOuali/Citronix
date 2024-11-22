package com.example.demo.service.impl;

import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.DTO.RecolteDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.RecolteMapper;
import com.example.demo.model.Ferme;
import com.example.demo.model.Recolte;
import com.example.demo.repository.RecolteRepository;
import com.example.demo.service.RecolteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RecolteServiceImpl implements RecolteService {

    @Autowired
    private RecolteRepository recolteRepository;

    @Autowired
    private RecolteMapper recolteMapper;


    @Override
    public RecolteResponseDTO addRecolte(RecolteCreateDTO recolteCreateDTO) {
        Recolte recolte = recolteMapper.createDT0toRecolte(recolteCreateDTO);
        recolteRepository.save(recolte);
        return recolteMapper.recolteToDTO(recolte);
    }

    @Override
    public RecolteDTO updateRecolte(RecolteDTO recolteDTO) {
        return null;
    }

    @Override
    public void deleteRecolte(UUID recolteId) {
        Recolte existingRecolte = recolteRepository.findById(recolteId)
                .orElseThrow(() -> new CustomException("Recolte not found with id: " + recolteId));
        recolteRepository.delete(existingRecolte);
    }

    @Override
    public RecolteDTO getRecolteById(UUID id) {
        Recolte recolte = recolteRepository.findById(id).orElse(null);
        return mapToDTO(recolte);
    }

    @Override
    public List<RecolteResponseDTO> getAllRecolte() {
        List<Recolte> recoltes = recolteRepository.findAll();
        return recoltes.stream().map(recolteMapper::recolteToDTO).collect(Collectors.toList());

    }

    private RecolteDTO mapToDTO(Recolte recolte) {
        RecolteDTO recolteDTO = new RecolteDTO();
        recolteDTO.setId(recolte.getId());
        recolteDTO.setDateRecolte(recolte.getDateRecolte());
        recolteDTO.setSaison(recolte.getSaison());
        recolteDTO.setQuantiteTotale(recolte.getQuantiteTotale());
        return recolteDTO;
    }
}

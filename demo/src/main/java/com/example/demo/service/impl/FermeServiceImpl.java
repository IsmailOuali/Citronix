package com.example.demo.service.impl;

import com.example.demo.DTO.FermeDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.model.Ferme;
import com.example.demo.repository.FermeRepository;
import com.example.demo.service.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FermeServiceImpl implements FermeService {

    @Autowired
    private FermeRepository fermeRepository;

    @Override
    public FermeDTO addFerme(Ferme ferme) {
        Ferme savedFerme = fermeRepository.save(ferme);
        return mapToDTO(savedFerme);
    }

    @Override
    public FermeDTO updateFerme(Ferme ferme) {
        Ferme existingFerme = fermeRepository.findById(ferme.getId())
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + ferme.getId()));
        existingFerme.setNom(ferme.getNom());
        existingFerme.setLocalisation(ferme.getLocalisation());
        existingFerme.setSuperficie(ferme.getSuperficie());
        existingFerme.setDateCreation(ferme.getDateCreation());
        Ferme updatedFerme = fermeRepository.save(existingFerme);
        return mapToDTO(updatedFerme);
    }

    @Override
    public FermeDTO getFermeById(UUID id) {
        Ferme ferme = fermeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + id));
        return mapToDTO(ferme);
    }

    @Override
    public List<FermeDTO> getAllFermes() {
        List<Ferme> fermes = fermeRepository.findAll();
        return fermes.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteFermeById(UUID id) {
        Ferme existingFerme = fermeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + id));
        fermeRepository.delete(existingFerme);
    }

    // Utility method to map Ferme to FermeDTO
    private FermeDTO mapToDTO(Ferme ferme) {
        FermeDTO fermeDTO = new FermeDTO();
        fermeDTO.setId(ferme.getId());
        fermeDTO.setNom(ferme.getNom());
        fermeDTO.setLocalisation(ferme.getLocalisation());
        fermeDTO.setSuperficie(ferme.getSuperficie());
        fermeDTO.setDateCreation(ferme.getDateCreation());
        return fermeDTO;
    }
}

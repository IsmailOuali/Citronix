package com.example.demo.service.impl;

import com.example.demo.DTO.Ferme.FermeCreateDTO;
import com.example.demo.DTO.Ferme.FermeResponseDTO;
import com.example.demo.DTO.Ferme.FermeSearchCriteria;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.FermeMapper;
import com.example.demo.model.Ferme;
import com.example.demo.repository.FermeRepository;
import com.example.demo.repository.custom.FermeCustomRepository;
import com.example.demo.service.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class FermeServiceImpl implements FermeService {

    @Autowired
    private FermeRepository fermeRepository;

    @Autowired
    private FermeCustomRepository fermeCustomRepository;

    @Autowired
    private FermeMapper fermeMapper;

    @Override
    public FermeResponseDTO addFerme(FermeCreateDTO fermeCreateDTO) {
        Ferme ferme = fermeMapper.createDTOtoFerme(fermeCreateDTO);
        ferme.setDateCreation(LocalDate.now());
        fermeRepository.save(ferme);
        return fermeMapper.fermeToResponseDTO(ferme);
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

    @Override
    public List<FermeResponseDTO> searchFermes(FermeSearchCriteria criteria) {
        List<Ferme> fermes = fermeCustomRepository.searchFermes(criteria);
        return fermes.stream().map(fermeMapper::fermeToResponseDTO).collect(Collectors.toList());
    }

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

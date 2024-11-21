package com.example.demo.service.impl;

import com.example.demo.DTO.ArbreDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.ArbreMapper;
import com.example.demo.mapper.ChampMapper;
import com.example.demo.model.Arbre;
import com.example.demo.repository.ArbreRepository;
import com.example.demo.service.ArbreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ArbreServiceImpl implements ArbreService {

    @Autowired
    private ArbreRepository arbreRepository;

    @Autowired
    private ArbreMapper arbreMapper;

    @Autowired
    private ChampMapper champMapper;

    @Override
    public ArbreDTO addArbre(ArbreDTO arbreDTO) {
        Arbre arbre = arbreMapper.toEntity(arbreDTO); // Convert DTO to entity
        Arbre savedArbre = arbreRepository.save(arbre);
        return arbreMapper.toDto(savedArbre); // Convert back to DTO after saving
    }

    @Override
    public ArbreDTO updateArbre(UUID id, ArbreDTO arbreDTO) {
        Arbre existingArbre = arbreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Arbre not found with id: " + id));

        existingArbre.setAge(arbreDTO.getAge());
        existingArbre.setDatePlantation(arbreDTO.getDatePlantation());
        existingArbre.setChamp(champMapper.toEntity(arbreDTO.getChamp())); // Mapping Champ

        Arbre updatedArbre = arbreRepository.save(existingArbre);
        return arbreMapper.toDto(updatedArbre);
    }

    @Override
    public ArbreDTO getArbreById(UUID id) {
        Arbre arbre = arbreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Arbre not found with id: " + id));
        return arbreMapper.toDto(arbre); // Convert entity to DTO
    }

    @Override
    public List<ArbreDTO> getAllArbres() {
        List<Arbre> arbres = arbreRepository.findAll();
        return arbreMapper.toDto(arbres);
    }

    @Override
    public void deleteArbreById(UUID id) {
        Arbre existingArbre = arbreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Arbre not found with id: " + id));
        arbreRepository.delete(existingArbre);
    }
}

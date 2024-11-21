package com.example.demo.service.impl;

import com.example.demo.DTO.Arbre.ArbreCreateDTO;
import com.example.demo.DTO.Arbre.ArbreResponseDTO;
import com.example.demo.DTO.ArbreDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.ArbreMapper;
import com.example.demo.mapper.ChampMapper;
import com.example.demo.model.Arbre;
import com.example.demo.model.Champ;
import com.example.demo.repository.ArbreRepository;
import com.example.demo.repository.ChampRepository;
import com.example.demo.service.ArbreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ArbreServiceImpl implements ArbreService {

    @Autowired
    private ArbreRepository arbreRepository;

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private ArbreMapper arbreMapper;

    @Autowired
    private ChampMapper champMapper;

    @Override
    public ArbreResponseDTO addArbre(ArbreCreateDTO arbreCreateDTO) {
        Arbre arbre = arbreMapper.createDtotoEntity(arbreCreateDTO);

        Champ champ = champRepository.findById(arbreCreateDTO.getChamp().getId())
                .orElseThrow(() -> new CustomException("Champ not found with id: " + arbreCreateDTO.getChamp().getId()));

        double maxAllowedTrees = champ.getSuperficie() / 10;

        long currentTreeCount = arbreRepository.countByChampId(champ.getId());

        if (currentTreeCount >= maxAllowedTrees) {
            throw new CustomException("The maximum number of trees for this champ has been reached.");
        }

        arbre.setChamp(champ);

        Arbre savedArbre = arbreRepository.save(arbre);

        return arbreMapper.arbreToResponseDTO(savedArbre);
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
    public List<Arbre> getAllArbres() {
        List<Arbre> arbres = arbreRepository.findAll();
        return arbres;
    }

    @Override
    public void deleteArbreById(UUID id) {
        Arbre existingArbre = arbreRepository.findById(id)
                .orElseThrow(() -> new CustomException("Arbre not found with id: " + id));
        arbreRepository.delete(existingArbre);
    }
}

package com.example.demo.service.impl;

import com.example.demo.DTO.ChampDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.ChampMapper;
import com.example.demo.mapper.FermeMapper;
import com.example.demo.model.Champ;
import com.example.demo.model.Ferme;
import com.example.demo.repository.ChampRepository;
import com.example.demo.repository.FermeRepository;
import com.example.demo.service.ChampService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ChampServiceImpl  implements ChampService {

    private final ChampRepository champRepository;
    private final FermeRepository fermeRepository;
    private final ChampMapper champMapper;
    private final FermeMapper fermeMapper;



    @Override
    public ChampDTO addChamp(UUID fermeId, ChampDTO champDTO) {
        Ferme ferme = fermeRepository.findById(fermeId)
                .orElseThrow(() -> new CustomException("Ferme not found"));

        double totalSuperficieChamps = ferme.getChamps().stream()
                .mapToDouble(Champ::getSuperficie)
                .sum();

        if (champDTO.getSuperficie() > 1000) {
            throw new CustomException("La superficie d'un champ ne doit pas dépasser 1000.");
        }

        if (totalSuperficieChamps + champDTO.getSuperficie() > ferme.getSuperficie()) {
            throw new CustomException("La somme des superficies des champs dépasse la superficie de la ferme.");
        }

        Champ champ = champMapper.toEntity(champDTO);
        champ.setFerme(ferme);
        Champ savedChamp = champRepository.save(champ);

        return champMapper.toDto(savedChamp);
    }

    @Override
    public ChampDTO updateChamp(ChampDTO champDTO) {
        Champ existingChamp = champRepository.findById(champDTO.getId())
                .orElseThrow(() -> new CustomException("Champ not found with id: " + champDTO.getId()));

        if (champDTO.getSuperficie() > 1000){
            throw new CustomException("La superficie d'un champ ne doit pas dépasser 1000.");

        }
        existingChamp.setSuperficie(champDTO.getSuperficie());

        Champ updatedChamp = champRepository.save(existingChamp);

        return champMapper.toDto(updatedChamp);
    }

    @Override
    public void deleteChampById(UUID id) {
        Champ existingChamp = champRepository.findById(id)
                .orElseThrow(() -> new CustomException("Champ not found with id: " + id));
        champRepository.delete(existingChamp);
    }

    @Override
    public ChampDTO getChampById(UUID id) {
        Champ champ = champRepository.findById(id)
                .orElseThrow(() -> new CustomException("Champ not found with id: " + id));
        return champMapper.toDto(champ);
    }

    @Override
    public List<ChampDTO> getAllChamps() {
        return champRepository.findAll().stream()
                .map(champMapper::toDto)
                .collect(Collectors.toList());
    }
}

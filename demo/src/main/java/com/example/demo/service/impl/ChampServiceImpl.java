package com.example.demo.service.impl;

import com.example.demo.DTO.Champ.ChampCreateDTO;
import com.example.demo.DTO.Champ.ChampResponseDTO;
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
    public ChampResponseDTO addChamp(UUID fermeId, ChampCreateDTO champCreateDTO) {
        Ferme ferme = fermeRepository.findById(fermeId)
                .orElseThrow(() -> new CustomException("Ferme not found"));

        double totalSuperficieChamps = ferme.getChamps().stream()
                .mapToDouble(Champ::getSuperficie)
                .sum();

        if (champCreateDTO.getSuperficie() < 1000) {
            throw new CustomException("La superficie d'un champ  doit pas dépasser 1000.");
        }

        if (totalSuperficieChamps + champCreateDTO.getSuperficie() > ferme.getSuperficie()) {
            throw new CustomException("La somme des superficies des champs dépasse la superficie de la ferme.");
        }

        Champ champ = champMapper.createDTOtoChamp(champCreateDTO);
        champ.setFerme(ferme);
        Champ savedChamp = champRepository.save(champ);

        return champMapper.champToResponseDTO(savedChamp);
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

        return mapToDto(updatedChamp);
    }

    @Override
    public void deleteChampById(UUID id) {
        Champ existingChamp = champRepository.findById(id)
                .orElseThrow(() -> new CustomException("Champ not found with id: " + id));
        champRepository.delete(existingChamp);
    }

    @Override
    public ChampResponseDTO getChampById(UUID champId) {
        Champ champ = champRepository.findById(champId).orElseThrow(() -> new RuntimeException("Champ not found"));
        return champMapper.champToResponseDTO(champ);
    }

    @Override
    public List<ChampDTO> getAllChamps() {
        return champRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ChampDTO mapToDto(Champ champ) {
        ChampDTO champDTO = new ChampDTO();
        champDTO.setId(champ.getId());
        champDTO.setSuperficie(champ.getSuperficie());
        return champDTO;

    }

}

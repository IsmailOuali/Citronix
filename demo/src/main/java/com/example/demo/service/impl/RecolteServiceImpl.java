package com.example.demo.service.impl;

import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.DTO.RecolteDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.RecolteMapper;
import com.example.demo.model.Arbre;
import com.example.demo.model.DetailRecolte;
import com.example.demo.model.Recolte;
import com.example.demo.repository.ArbreRepository;
import com.example.demo.repository.DetailRecolteRepository;
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
    private ArbreRepository arbreRepository;

    @Autowired
    private DetailRecolteRepository detailRecolteRepository;

    @Autowired
    private RecolteMapper recolteMapper;


    @Override
    public RecolteResponseDTO addRecolte(UUID champId, RecolteCreateDTO recolteCreateDTO) {
            List<Arbre> arbresInChamp = arbreRepository.findByChampId(champId);

        if (arbresInChamp.isEmpty()) {
            throw new IllegalArgumentException("Champ has no Arbres for the Recolte.");
        }

        List<DetailRecolte> allDetailRecoltes = detailRecolteRepository.findByArbreId(champId);
        double totalQuantiteRecoltee = allDetailRecoltes.stream()
                .mapToDouble(DetailRecolte::getQuantiteRecoltee)
                .sum();

        Recolte recolte = recolteMapper.createDT0toRecolte(recolteCreateDTO);
        recolte.setQuantiteTotale(totalQuantiteRecoltee);

        recolteRepository.save(recolte);

        double updatedQuantiteTotale = detailRecolteRepository.sumQuantiteByRecolteId(recolte.getId());
        recolte.setQuantiteTotale(updatedQuantiteTotale);  // Update with the latest sum
        recolteRepository.save(recolte);  // Save the updated Recolte with the correct total quantity

        return recolteMapper.recolteToDTO(recolte);
    }


    @Override
    public RecolteDTO updateRecolte(Recolte recolte) {
        return null;
    }

    @Override
    public void deleteRecolte(UUID recolteId) {
        Recolte existingRecolte = recolteRepository.findById(recolteId)
                .orElseThrow(() -> new CustomException("Recolte not found with id: " + recolteId));
        recolteRepository.delete(existingRecolte);
    }

    @Override
    public RecolteResponseDTO getRecolteById(UUID id) {
        Recolte recolte = recolteRepository.findById(id).orElseThrow(() -> new CustomException("Recolte not found with id: " + id));
        return recolteMapper.recolteToDTO(recolte);
    }

    @Override
    public List<RecolteResponseDTO> getAllRecolte() {
        List<Recolte> recoltes = recolteRepository.findAll();
        return recoltes.stream().map(recolteMapper::recolteToDTO).collect(Collectors.toList());

    }

}

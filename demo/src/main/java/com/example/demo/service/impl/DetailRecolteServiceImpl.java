package com.example.demo.service.impl;


import com.example.demo.DTO.DetailRecolte.DetailRecolteCreateDTO;
import com.example.demo.DTO.DetailRecolte.DetailRecolteResponseDTO;
import com.example.demo.mapper.DetailRecolteMapper;
import com.example.demo.model.Arbre;
import com.example.demo.model.DetailRecolte;
import com.example.demo.repository.ArbreRepository;
import com.example.demo.repository.DetailRecolteRepository;
import com.example.demo.service.DetailRecolteService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailRecolteServiceImpl implements DetailRecolteService {

    private final DetailRecolteRepository detailRecolteRepository;
    private final ArbreRepository arbreRepository;

    private final DetailRecolteMapper detailRecolteMapper;

    @Override
    public DetailRecolteResponseDTO addDetailRecolte(DetailRecolteCreateDTO detailRecolteCreateDTO) {
        UUID arbreId = detailRecolteCreateDTO.getArbre().getId();
        Arbre arbre = arbreRepository.findById(arbreId)
                .orElseThrow(() -> new IllegalArgumentException("Arbre not found"));

        double maxQuantity = calculateMaxQuantity(arbre.getAge());

        DetailRecolte detailRecolte = detailRecolteMapper.createDtotoDetailRecolte(detailRecolteCreateDTO);
        detailRecolte.setQuantiteRecoltee(maxQuantity);

        DetailRecolte savedDetailRecolte = detailRecolteRepository.save(detailRecolte);

        return detailRecolteMapper.detailRecolteToResponseDTO(savedDetailRecolte);
    }

    @Override
    public double calculateMaxQuantity(int age) {
        if (age < 3) {
            return 2.5;
        } else if (age <= 10) {
            return 12.0;
        } else {
            return 20.0;
        }
    }

    @Override
    public List<DetailRecolteResponseDTO> getAllDetailRecoltes() {
        List<DetailRecolte> detailRecoltes = detailRecolteRepository.findAll();

        return detailRecoltes.stream()
                .map(detailRecolteMapper::detailRecolteToResponseDTO)
                .collect(Collectors.toList());
    }

}

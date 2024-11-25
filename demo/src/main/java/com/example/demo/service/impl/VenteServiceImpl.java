package com.example.demo.service.impl;

import com.example.demo.DTO.Vente.VenteCreateDTO;
import com.example.demo.DTO.Vente.VenteResponseDTO;
import com.example.demo.DTO.VenteDTO;
import com.example.demo.exception.CustomException;
import com.example.demo.mapper.VenteMapper;
import com.example.demo.model.Recolte;
import com.example.demo.model.Vente;
import com.example.demo.repository.RecolteRepository;
import com.example.demo.repository.VenteRepository;
import com.example.demo.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class VenteServiceImpl implements VenteService {

    @Autowired
    private RecolteRepository recolteRepository;

    @Autowired
    private VenteRepository venteRepository;

    @Autowired
    private VenteMapper venteMapper;



    @Override
    public VenteResponseDTO createVente(UUID recolteId, VenteCreateDTO venteCreateDTO) {
        Recolte recolte = recolteRepository.findById(recolteId).orElseThrow(()
        -> new CustomException("Recolte Not Found"));

        Vente vente = venteMapper.venteCreateDTOToVente(venteCreateDTO);
        vente.setRecolte(recolte);
        venteRepository.save(vente);

        return venteMapper.venteToVenteResponseDTO(vente);
    }

    @Override
    public VenteResponseDTO updateVente(VenteCreateDTO venteCreateDTO) {
        return null;
    }

    @Override
    public void deleteVente(UUID id) {
        Vente exsistingVente = venteRepository.findById(id).orElseThrow(() -> new CustomException("Vente Not Found"));

         venteRepository.delete(exsistingVente);
    }

    @Override
    public List<VenteResponseDTO> getAllVentes() {
        List<Vente> venteList = venteRepository.findAll();
        return venteList.stream().map(venteMapper::venteToVenteResponseDTO).collect(Collectors.toList());
    }

    @Override
    public VenteResponseDTO getVenteById(UUID id) {
        Vente existVente = venteRepository.findById(id).orElseThrow(() -> new CustomException("Vente Not Found"));
        return venteMapper.venteToVenteResponseDTO(existVente);
    }


}

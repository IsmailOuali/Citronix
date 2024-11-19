package com.example.demo.service.impl;

import com.example.demo.exception.CustomException;
import com.example.demo.model.Champ;
import com.example.demo.model.Ferme;
import com.example.demo.repository.ChampRepository;
import com.example.demo.repository.FermeRepository;
import com.example.demo.service.champService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class champServiceImpl implements champService {

    @Autowired
    private ChampRepository champRepository;

    @Autowired
    private FermeRepository fermeRepository;

    public Champ addChamp(UUID fermeId, Champ champ) {
        Ferme ferme = fermeRepository.findById(fermeId)
                .orElseThrow(() -> new CustomException("Ferme not found"));

        double totalSuperficieChamps = ferme.getChamps().stream()
                .mapToDouble(Champ::getSuperficie)
                .sum();

        if (champ.getSuperficie() > 1000) {
            throw new CustomException("La superficie d'un champ ne doit pas dépasser 1000.");
        }

        if (totalSuperficieChamps + champ.getSuperficie() > ferme.getSuperficie()) {
            throw new CustomException("La somme des superficies des champs dépasse la superficie de la ferme.");
        }

        champ.setFerme(ferme);
        return champRepository.save(champ);
    }

    @Override
    public Champ updateChamp(Champ champ) {
        Champ existingChamp = champRepository.findById(champ.getId())
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + champ.getId()));
        existingChamp.setFerme(champ.getFerme());
        existingChamp.setSuperficie(champ.getSuperficie());

        return champRepository.save(existingChamp);
    }

    @Override
    public void deleteChampById(UUID id) {
        Champ existingChamp = champRepository.findById(id)
                .orElseThrow(() -> new CustomException("Champ not found with id: " + id));
            champRepository.delete(existingChamp);
    }

    @Override
    public Champ getChampById(UUID id) {
        return champRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + id));
    }

    @Override
    public List<Champ> getAllChamps() {
        return champRepository.findAll();
    }
}

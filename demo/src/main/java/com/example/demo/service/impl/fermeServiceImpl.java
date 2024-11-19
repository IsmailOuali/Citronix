package com.example.demo.service.impl;

import com.example.demo.model.Ferme;
import com.example.demo.repository.FermeRepository;
import com.example.demo.service.fermeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class fermeServiceImpl implements fermeService {


    @Autowired
    private FermeRepository fermeRepository;

    @Override
    public Ferme addFerme(Ferme ferme) {
        return fermeRepository.save(ferme);
    }

    @Override
    public Ferme updateFerme(UUID id, Ferme ferme) {
        Ferme existingFerme = fermeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + id));
        existingFerme.setNom(ferme.getNom());
        existingFerme.setLocalisation(ferme.getLocalisation());
        existingFerme.setSuperficie(ferme.getSuperficie());
        existingFerme.setDateCreation(ferme.getDateCreation());
        return fermeRepository.save(existingFerme);
    }

    @Override
    public Ferme getFermeById(UUID id) {
        return fermeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + id));
    }

    @Override
    public List<Ferme> getAllFermes() {
        return fermeRepository.findAll();
    }

    @Override
    public void deleteFerme(UUID id) {
        Ferme existingFerme = fermeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Ferme not found with id: " + id));
        fermeRepository.delete(existingFerme);
    }

    @Override
    public void deleteFermeById(UUID ferme) {

    }
}

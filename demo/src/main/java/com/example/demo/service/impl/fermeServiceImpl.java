package com.example.demo.service.impl;

import com.example.demo.model.Ferme;
import com.example.demo.repository.FermeRepository;
import com.example.demo.service.fermeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class fermeServiceImpl implements fermeService {


    @Autowired
    private FermeRepository fermeRepository;

    @Override
    public Ferme addFerme(Ferme ferme) {
        return null;
    }

    @Override
    public Ferme updateFerme(Ferme ferme) {
        return null;
    }

    @Override
    public void deleteFermeById(UUID ferme) {

    }
}

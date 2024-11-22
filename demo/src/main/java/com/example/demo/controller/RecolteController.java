package com.example.demo.controller;


import com.example.demo.DTO.Champ.ChampCreateDTO;
import com.example.demo.DTO.Champ.ChampResponseDTO;
import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.DTO.RecolteDTO;
import com.example.demo.mapper.RecolteMapper;
import com.example.demo.model.Recolte;
import com.example.demo.service.RecolteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/recoltes")
public class RecolteController {

    @Autowired
    private RecolteService recolteService;

    @Autowired
    private RecolteMapper recolteMapper;


    @PostMapping
    public ResponseEntity<RecolteResponseDTO> addChamp(@RequestBody RecolteCreateDTO recolteCreateDTO) {
        RecolteResponseDTO recolteResponseDTO = recolteService.addRecolte(recolteCreateDTO);
        return ResponseEntity.status(201).body(recolteResponseDTO);
    }

    @PutMapping
    public ResponseEntity<RecolteDTO> updateChamp(@RequestBody RecolteDTO recolteDTO) {
        Recolte recolte = new Recolte();
        recolte.setId(recolteDTO.getId());
        recolte.setSaison(recolteDTO.getSaison());
        recolte.setQuantiteTotale(recolteDTO.getQuantiteTotale());
        recolte.setDateRecolte(recolteDTO.getDateRecolte());

        RecolteDTO recolteupdate = recolteService.updateRecolte(recolte);
        return ResponseEntity.status(201).body(recolteupdate);
    }



}

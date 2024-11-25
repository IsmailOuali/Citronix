package com.example.demo.controller;


import com.example.demo.DTO.FermeDTO;
import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.DTO.RecolteDTO;
import com.example.demo.mapper.RecolteMapper;
import com.example.demo.model.Recolte;
import com.example.demo.service.RecolteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/recoltes")
public class RecolteController {

    @Autowired
    private RecolteService recolteService;

    @Autowired
    private RecolteMapper recolteMapper;


    @PostMapping("/{champId}")
    public ResponseEntity<RecolteResponseDTO> addRecolte(@Valid @PathVariable UUID champId,@RequestBody RecolteCreateDTO recolteCreateDTO) {
        RecolteResponseDTO recolteResponseDTO = recolteService.addRecolte(champId, recolteCreateDTO);
        return ResponseEntity.status(201).body(recolteResponseDTO);
    }

    @PutMapping
    public ResponseEntity<RecolteDTO> updateRecolte(@RequestBody RecolteDTO recolteDTO) {
        Recolte recolte = new Recolte();
        recolte.setId(recolteDTO.getId());
        recolte.setSaison(recolteDTO.getSaison());
        recolte.setQuantiteTotale(recolteDTO.getQuantiteTotale());
        recolte.setDateRecolte(recolteDTO.getDateRecolte());

        RecolteDTO recolteupdate = recolteService.updateRecolte(recolte);
        return ResponseEntity.status(201).body(recolteupdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RecolteResponseDTO> deleteRecolte(@PathVariable UUID id) {
        recolteService.deleteRecolte(id);
        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity<List<RecolteResponseDTO>> getAllRecoltes() {
       List<RecolteResponseDTO> recolteResponseDTOSDTOS = recolteService.getAllRecolte();
       return ResponseEntity.ok(recolteResponseDTOSDTOS);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecolteResponseDTO> getRecolteById(@PathVariable UUID id) {
        RecolteResponseDTO recolteResponseDTO = recolteService.getRecolteById(id);
        return ResponseEntity.ok(recolteResponseDTO);
    }



}

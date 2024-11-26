package com.example.demo.controller;


import com.example.demo.DTO.Vente.VenteCreateDTO;
import com.example.demo.DTO.Vente.VenteResponseDTO;
import com.example.demo.mapper.VenteMapper;
import com.example.demo.model.Recolte;
import com.example.demo.model.Vente;
import com.example.demo.service.RecolteService;
import com.example.demo.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ventes")
public class VenteController {

    @Autowired
    private  VenteService venteService;





    @PostMapping("/{recolteId}")
    public ResponseEntity<VenteResponseDTO> createVente(@PathVariable UUID recolteId, @RequestBody VenteCreateDTO venteCreateDTO) {
        VenteResponseDTO venteResponseDTO = venteService.createVente(recolteId, venteCreateDTO);
        return ResponseEntity.ok(venteResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<VenteResponseDTO>> getAllVentes() {
        List<VenteResponseDTO> ventes = venteService.getAllVentes();
        return ResponseEntity.ok(ventes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenteResponseDTO> updateVente(@PathVariable UUID id, @RequestBody VenteCreateDTO venteCreateDTO) {

        VenteResponseDTO vente = venteService.updateVente(venteCreateDTO);

        return ResponseEntity.status(201).body(vente);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VenteResponseDTO> deleteVente(@PathVariable UUID id) {
        venteService.deleteVente(id);
        return ResponseEntity.status(204).build();
    }
}

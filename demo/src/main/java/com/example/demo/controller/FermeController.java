package com.example.demo.controller;

import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Ferme;
import com.example.demo.service.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/fermes")
public class FermeController {

    @Autowired
    private FermeService fermeService;

    // Add Ferme
    @PostMapping
    public ResponseEntity<FermeDTO> addFerme(@RequestBody FermeDTO fermeDTO) {
        Ferme ferme = new Ferme();
        ferme.setNom(fermeDTO.getNom());
        ferme.setLocalisation(fermeDTO.getLocalisation());
        ferme.setSuperficie(fermeDTO.getSuperficie());
        ferme.setDateCreation(fermeDTO.getDateCreation());

        FermeDTO createdFerme = fermeService.addFerme(ferme);
        return ResponseEntity.status(201).body(createdFerme);
    }

    // Update Ferme
    @PutMapping
    public ResponseEntity<FermeDTO> updateFerme(@RequestBody FermeDTO fermeDTO) {
        Ferme ferme = new Ferme();
        ferme.setId(fermeDTO.getId());
        ferme.setNom(fermeDTO.getNom());
        ferme.setLocalisation(fermeDTO.getLocalisation());
        ferme.setSuperficie(fermeDTO.getSuperficie());
        ferme.setDateCreation(fermeDTO.getDateCreation());

        FermeDTO updatedFerme = fermeService.updateFerme(ferme);
        return ResponseEntity.ok(updatedFerme);
    }

    // Get a Ferme by ID
    @GetMapping("/{id}")
    public ResponseEntity<FermeDTO> getFermeById(@PathVariable UUID id) {
        FermeDTO fermeDTO = fermeService.getFermeById(id);
        return ResponseEntity.ok(fermeDTO);
    }

    // Get all Fermes
    @GetMapping
    public ResponseEntity<List<FermeDTO>> getAllFermes() {
        List<FermeDTO> fermeDTOs = fermeService.getAllFermes();
        return ResponseEntity.ok(fermeDTOs);
    }

    // Delete Ferme by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFerme(@PathVariable UUID id) {
        fermeService.deleteFermeById(id);
        return ResponseEntity.noContent().build();
    }
}

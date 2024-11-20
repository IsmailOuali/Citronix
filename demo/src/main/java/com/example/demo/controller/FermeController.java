package com.example.demo.controller;


import com.example.demo.DTO.FermeDTO;
import com.example.demo.mapper.FermeMapper;
import com.example.demo.model.Ferme;
import com.example.demo.service.FermeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ferme")
public class FermeController {

    @Autowired
    private FermeService fermeService;

    @Autowired
    private FermeMapper fermeMapper;

    @GetMapping
    public List<Ferme> getAllFermes() {
        return fermeService.getAllFermes();
    }

    @PostMapping
    public ResponseEntity<FermeDTO> createFerme(@RequestBody FermeDTO fermeDTO) {
        Ferme ferme = fermeMapper.toEntity(fermeDTO); // Use instance method

        Ferme savedFerme = fermeService.addFerme(ferme);

        FermeDTO savedFermeDTO = fermeMapper.toDto(savedFerme); // Use instance method

        return new ResponseEntity<>(savedFermeDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FermeDTO> updateFerme(@PathVariable UUID id, @RequestBody FermeDTO fermeDTO) {
        Ferme existingFerme = fermeService.getFermeById(id);

        if (existingFerme == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (fermeDTO.getNom() != null) {
            existingFerme.setNom(fermeDTO.getNom());
        }
        if (fermeDTO.getLocalisation() != null) {
            existingFerme.setLocalisation(fermeDTO.getLocalisation());
        }
        if (fermeDTO.getSuperficie() != 0) {
            existingFerme.setSuperficie(fermeDTO.getSuperficie());
        }
        if (fermeDTO.getDateCreation() != null) {
            existingFerme.setDateCreation(fermeDTO.getDateCreation());
        }

        Ferme updatedFerme = fermeService.addFerme(existingFerme);

        FermeDTO updatedFermeDTO = fermeMapper.toDto(updatedFerme); // Use instance method
        return new ResponseEntity<>(updatedFermeDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFerme(@PathVariable UUID id) {
        Ferme existingFerme = fermeService.getFermeById(id);

        if (existingFerme == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        fermeService.deleteFermeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}





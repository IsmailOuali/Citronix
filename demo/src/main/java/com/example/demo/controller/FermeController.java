package com.example.demo.controller;


import com.example.demo.DTO.FermeDTO;
import com.example.demo.mapper.FermeMapper;
import com.example.demo.model.Ferme;
import com.example.demo.service.FermeService;
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


    @GetMapping
    public List<Ferme> getAllFermes(){
        return fermeService.getAllFermes();
    }

    @PostMapping
    public ResponseEntity<FermeDTO> createFerme(@RequestBody FermeDTO fermDTO) {
        Ferme ferm = FermeMapper.toEntity(fermDTO);

        Ferme savedFerm = fermeService.addFerme(ferm);

        FermeDTO savedFermDTO = FermeMapper.toDTO(savedFerm);

        return new ResponseEntity<>(savedFermDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FermeDTO> updateFerme(@PathVariable UUID id, @RequestBody FermeDTO fermeDTO) {
        Ferme existingFerme = fermeService.getFermeById(id);

        if (existingFerme == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingFerme.setNom(fermeDTO.getNom());
        existingFerme.setLocalisation(fermeDTO.getLocalisation());
        existingFerme.setSuperficie(fermeDTO.getSuperficie());
        existingFerme.setDateCreation(fermeDTO.getDateCreation());

        Ferme updatedFerme = fermeService.addFerme(existingFerme);

        FermeDTO updatedFermeDTO = FermeMapper.toDTO(updatedFerme);
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




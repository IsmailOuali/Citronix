package com.example.demo.controller;

import com.example.demo.DTO.Arbre.ArbreCreateDTO;
import com.example.demo.DTO.Arbre.ArbreResponseDTO;
import com.example.demo.DTO.ArbreDTO;
import com.example.demo.service.ArbreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/arbres")
public class ArbreController {

    @Autowired
    private ArbreService arbreService;

    @PostMapping("/{champId}")
    public ResponseEntity<ArbreResponseDTO> addArbre(@PathVariable UUID champId, @RequestBody ArbreCreateDTO arbreCreateDTO) {
        ArbreResponseDTO createdArbre = arbreService.addArbre(champId, arbreCreateDTO);
        return ResponseEntity.ok(createdArbre);
    }

    // Update an existing Arbre by ID
    @PutMapping("/{id}")
    public ResponseEntity<ArbreDTO> updateArbre(@PathVariable UUID id, @RequestBody ArbreDTO arbreDTO) {
        ArbreDTO updatedArbre = arbreService.updateArbre(id, arbreDTO);
        return ResponseEntity.ok(updatedArbre);
    }

    // Get a specific Arbre by ID
    @GetMapping("/{id}")
    public ResponseEntity<ArbreDTO> getArbreById(@PathVariable UUID id) {
        ArbreDTO arbreDTO = arbreService.getArbreById(id);
        return ResponseEntity.ok(arbreDTO);
    }

    // Get all Arbres
    @GetMapping
    public ResponseEntity<List<ArbreDTO>> getAllArbres() {
        List<ArbreDTO> arbres = arbreService.getAllArbres();
        return ResponseEntity.ok(arbres);
    }

    // Delete an Arbre by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArbre(@PathVariable UUID id) {
        arbreService.deleteArbreById(id);
        return ResponseEntity.noContent().build();
    }
}

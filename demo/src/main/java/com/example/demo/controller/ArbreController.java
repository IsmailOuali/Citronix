package com.example.demo.controller;

import com.example.demo.DTO.Arbre.ArbreCreateDTO;
import com.example.demo.DTO.Arbre.ArbreResponseDTO;
import com.example.demo.DTO.ArbreDTO;
import com.example.demo.mapper.ArbreMapperImpl;
import com.example.demo.model.Arbre;
import com.example.demo.service.ArbreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/arbres")
public class ArbreController {

    @Autowired
    private ArbreService arbreService;
    @Autowired
    private ArbreMapperImpl arbreMapperImpl;

    // Create a new Arbre
    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ArbreResponseDTO> addArbre(@Valid @RequestBody ArbreCreateDTO arbreCreateDTO) {
        Arbre arbre = arbreMapperImpl.createDtotoEntity(arbreCreateDTO);
        ArbreResponseDTO createdArbre = arbreMapperImpl.arbreToResponseDTO(arbre);
        return ResponseEntity.status(201).body(createdArbre);
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
        return ResponseEntity.ok(arbreDTO);  // Responds with the requested ArbreDTO
    }

    // Get all Arbres
    @GetMapping
    public List<ArbreResponseDTO> getAllArbreResponseDTOs() {
        List<Arbre> arbres = arbreService.getAllArbres();
        return arbres.stream()
                .map(arbreMapperImpl::arbreToResponseDTO)
                .collect(Collectors.toList());
    }

    // Delete an Arbre by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArbre(@PathVariable UUID id) {
        arbreService.deleteArbreById(id);
        return ResponseEntity.noContent().build();  // Responds with a no-content status after deletion
    }
}

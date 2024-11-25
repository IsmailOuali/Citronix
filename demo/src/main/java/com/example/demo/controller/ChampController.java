package com.example.demo.controller;


import com.example.demo.DTO.Champ.ChampCreateDTO;
import com.example.demo.DTO.Champ.ChampResponseDTO;
import com.example.demo.DTO.ChampDTO;
import com.example.demo.service.ChampService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/champs")
public class ChampController {

    @Autowired
    private ChampService champService;  // Injecting ChampService

    @PostMapping
    public ResponseEntity<ChampResponseDTO> addChamp(@Valid @RequestBody ChampCreateDTO champCreateDTO) {
        ChampResponseDTO champResponseDTO = champService.addChamp(champCreateDTO);
        return ResponseEntity.status(201).body(champResponseDTO);
    }

    // Update an existing Champ
    @PutMapping()
    public ResponseEntity<ChampDTO> updateChamp(@RequestBody ChampDTO champDTO) {
        ChampDTO updatedChamp = champService.updateChamp(champDTO);
        return ResponseEntity.ok(updatedChamp);  // Returning updated ChampDTO with HTTP 200
    }

    // Delete a Champ by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteChamp(@PathVariable UUID id) {
        champService.deleteChampById(id);
        return ResponseEntity.noContent().build();
    }

    // Get a Champ by ID
    @GetMapping("/{id}")
    public ResponseEntity<ChampResponseDTO> getChampById(@PathVariable UUID id) {
        ChampResponseDTO champDTO = champService.getChampById(id);
        return ResponseEntity.ok(champDTO);
    }

    // Get all Champs
    @GetMapping
    public ResponseEntity<List<ChampDTO>> getAllChamps() {
        List<ChampDTO> champDTOs = champService.getAllChamps();
        return ResponseEntity.ok(champDTOs);
    }
}

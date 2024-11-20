package com.example.demo.controller;


import com.example.demo.DTO.ChampDTO;
import com.example.demo.service.ChampService;
import lombok.AllArgsConstructor;
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

    @PostMapping("/{fermeId}")
    public ResponseEntity<ChampDTO> addChamp(@PathVariable UUID fermeId, @RequestBody ChampDTO champDTO) {
        ChampDTO createdChamp = champService.addChamp(fermeId, champDTO);
        return ResponseEntity.status(201).body(createdChamp);
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
    public ResponseEntity<ChampDTO> getChampById(@PathVariable UUID id) {
        ChampDTO champDTO = champService.getChampById(id);
        return ResponseEntity.ok(champDTO);
    }

    // Get all Champs
    @GetMapping("/")
    public ResponseEntity<List<ChampDTO>> getAllChamps() {
        List<ChampDTO> champDTOs = champService.getAllChamps();
        return ResponseEntity.ok(champDTOs);
    }
}

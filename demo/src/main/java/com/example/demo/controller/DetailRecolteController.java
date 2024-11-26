package com.example.demo.controller;

import com.example.demo.DTO.DetailRecolte.DetailRecolteCreateDTO;
import com.example.demo.DTO.DetailRecolte.DetailRecolteResponseDTO;
import com.example.demo.service.DetailRecolteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/detailRecoltes")
@RequiredArgsConstructor
public class DetailRecolteController {

    private final DetailRecolteService detailRecolteService;

    @PostMapping
    public ResponseEntity<DetailRecolteResponseDTO> addDetailRecolte(@Valid @RequestBody DetailRecolteCreateDTO detailRecolteCreateDTO) {
        DetailRecolteResponseDTO createdDetailRecolte = detailRecolteService.addDetailRecolte(detailRecolteCreateDTO);
        return ResponseEntity.status(201).body(createdDetailRecolte);
    }

    @GetMapping
    public ResponseEntity<List<DetailRecolteResponseDTO>> getAllDetailRecoltes() {
        List<DetailRecolteResponseDTO> detailRecoltes = detailRecolteService.getAllDetailRecoltes();
        return ResponseEntity.ok(detailRecoltes);
    }
}

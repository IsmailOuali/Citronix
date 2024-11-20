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

}




package com.example.demo.controller;


import com.example.demo.model.Ferme;
import com.example.demo.service.FermeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Ferme createFerme(@RequestBody Ferme ferme){
        return fermeService.addFerme(ferme);
    }


}

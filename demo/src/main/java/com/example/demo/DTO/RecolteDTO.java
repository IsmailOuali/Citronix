package com.example.demo.DTO;

import com.example.demo.model.DetailRecolte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecolteDTO {

    private UUID id;

    private String saison;

    private LocalDate dateRecolte;

    private double quantiteTotale;


    private List<DetailRecolteDTO> detailsRecolte;
}

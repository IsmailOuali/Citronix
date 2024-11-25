package com.example.demo.DTO.Champ;

import com.example.demo.DTO.Ferme.FermeResponseDTO;
import com.example.demo.model.Arbre;
import com.example.demo.model.Ferme;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChampResponseDTO {
    private UUID id;

    private double superficie;

    @ManyToOne

    private FermeResponseDTO ferme;

//    private List<Arbre> arbres;
}

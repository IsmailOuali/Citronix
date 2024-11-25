package com.example.demo.mapper;


import com.example.demo.DTO.Vente.VenteCreateDTO;
import com.example.demo.DTO.Vente.VenteResponseDTO;
import com.example.demo.model.Vente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VenteMapper {
    VenteResponseDTO venteToVenteResponseDTO(Vente vente);
    Vente venteCreateDTOToVente(VenteCreateDTO venteResponseDTO);
}

package com.example.demo.mapper;


import com.example.demo.DTO.Recolte.RecolteCreateDTO;
import com.example.demo.DTO.Recolte.RecolteResponseDTO;
import com.example.demo.model.Recolte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RecolteMapper {
    Recolte createDT0toRecolte(RecolteCreateDTO recolteCreateDTO);
    RecolteResponseDTO recolteToDTO(Recolte recolte);
}

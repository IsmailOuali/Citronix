package com.example.demo.mapper;

import com.example.demo.DTO.Arbre.ArbreCreateDTO;
import com.example.demo.DTO.Arbre.ArbreResponseDTO;
import com.example.demo.DTO.ArbreDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Arbre;
import com.example.demo.model.Ferme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArbreMapper {

    ArbreMapper INSTANCE = Mappers.getMapper(ArbreMapper.class);

    ArbreDTO toDto(Arbre arbre);
    List<ArbreDTO> toDto(List<Arbre> arbres);
;

    Arbre toEntity(ArbreDTO arbreDTO);

    Arbre createDtotoEntity(ArbreCreateDTO arbreCreateDTO);
    List<Arbre> createDtotoEntity(List<ArbreCreateDTO> arbreCreateDTOs);
    ArbreResponseDTO arbreToResponseDTO(Arbre arbre);
}
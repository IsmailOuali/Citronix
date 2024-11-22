package com.example.demo.mapper;

import com.example.demo.DTO.Arbre.ArbreCreateDTO;
import com.example.demo.DTO.Arbre.ArbreResponseDTO;
import com.example.demo.DTO.ArbreDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Arbre;
import com.example.demo.model.Ferme;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArbreMapper {

    ArbreMapper INSTANCE = Mappers.getMapper(ArbreMapper.class);

    ArbreDTO toDto(Arbre arbre);

    @IterableMapping(elementTargetType = ArbreDTO.class)
    List<ArbreDTO> toDto(List<Arbre> arbres);
;

    Arbre toEntity(ArbreDTO arbreDTO);

    Arbre createDTOToArbre(ArbreCreateDTO arbreCreateDTO);
    ArbreResponseDTO arbreToResponseDTO(Arbre arbre);
}
package com.example.demo.mapper;

import com.example.demo.DTO.ArbreDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Arbre;
import com.example.demo.model.Ferme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ArbreMapper {

    ArbreMapper INSTANCE = Mappers.getMapper(ArbreMapper.class);

    ArbreDTO toDto(Arbre arbre);

    Arbre toEntity(ArbreDTO arbreDTO);
}
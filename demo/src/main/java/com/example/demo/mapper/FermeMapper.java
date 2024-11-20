package com.example.demo.mapper;

import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Ferme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FermeMapper {

    FermeMapper INSTANCE = Mappers.getMapper(FermeMapper.class);

     FermeDTO toDto(Ferme ferme);

     Ferme toEntity(FermeDTO fermeDTO);
}
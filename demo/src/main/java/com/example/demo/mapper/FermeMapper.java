package com.example.demo.mapper;

import com.example.demo.DTO.Ferme.FermeCreateDTO;
import com.example.demo.DTO.Ferme.FermeResponseDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Ferme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FermeMapper {


     Ferme createDTOtoFerme(FermeCreateDTO fermeCreateDTO);

     FermeResponseDTO fermeToResponseDTO(Ferme ferme);
}
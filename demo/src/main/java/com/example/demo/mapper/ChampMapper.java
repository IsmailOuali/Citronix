package com.example.demo.mapper;

import com.example.demo.DTO.ChampDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Champ;
import com.example.demo.model.Ferme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ArbreMapper.class, FermeMapper.class})
public interface ChampMapper {

    ChampMapper INSTANCE = Mappers.getMapper(ChampMapper.class);

    ChampDTO toDto(Champ champ);

    Champ toEntity(ChampDTO champDTO);
}
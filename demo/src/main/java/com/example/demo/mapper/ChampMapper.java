package com.example.demo.mapper;

import com.example.demo.DTO.ArbreDTO;
import com.example.demo.DTO.Champ.ChampCreateDTO;
import com.example.demo.DTO.Champ.ChampResponseDTO;
import com.example.demo.DTO.ChampDTO;
import com.example.demo.DTO.FermeDTO;
import com.example.demo.model.Arbre;
import com.example.demo.model.Champ;
import com.example.demo.model.Ferme;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {ArbreMapper.class, FermeMapper.class})
public interface ChampMapper {

   ChampMapper INSTANCE = Mappers.getMapper(ChampMapper.class);

   @Mapping(target = "ferme.id", source = "fermeId")
   Champ createDTOtoChamp(ChampCreateDTO champCreateDTO);

   ChampResponseDTO champToResponseDTO(Champ champ);
   
   ChampDTO toDto(Champ champ);
   Champ toEntity(ChampDTO champDTO);


}
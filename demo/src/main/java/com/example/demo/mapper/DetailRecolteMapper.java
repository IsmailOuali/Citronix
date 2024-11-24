package com.example.demo.mapper;

import com.example.demo.DTO.DetailRecolte.DetailRecolteCreateDTO;
import com.example.demo.DTO.DetailRecolte.DetailRecolteResponseDTO;
import com.example.demo.model.DetailRecolte;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailRecolteMapper {

        DetailRecolte createDtotoDetailRecolte(DetailRecolteCreateDTO detailRecolteCreateDTO);
        DetailRecolteResponseDTO detailRecolteToResponseDTO(DetailRecolte detailRecolte);
}

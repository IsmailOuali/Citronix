package com.example.demo.service;

import com.example.demo.DTO.DetailRecolte.DetailRecolteCreateDTO;
import com.example.demo.DTO.DetailRecolte.DetailRecolteResponseDTO;

import java.util.List;

public interface DetailRecolteService {
    List<DetailRecolteResponseDTO> getAllDetailRecoltes();
    DetailRecolteResponseDTO addDetailRecolte(DetailRecolteCreateDTO detailRecolteCreateDTO);
    double calculateMaxQuantity(int age);
}

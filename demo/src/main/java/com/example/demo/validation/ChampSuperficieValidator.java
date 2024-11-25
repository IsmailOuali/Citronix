package com.example.demo.validation;

import com.example.demo.DTO.Champ.ChampCreateDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ChampSuperficieValidator implements ConstraintValidator<ValidChampSuperficie, ChampCreateDTO> {

    @Override
    public boolean isValid(ChampCreateDTO champ, ConstraintValidatorContext context) {
        return true;
}
}

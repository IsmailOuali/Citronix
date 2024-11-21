package com.example.demo.validation.ValidChampSuperficie;

import com.example.demo.DTO.Champ.ChampCreateDTO;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ChampSuperficieValidator implements ConstraintValidator<ValidChampSuperficie, ChampCreateDTO> {

    @Override
    public boolean isValid(ChampCreateDTO champ, ConstraintValidatorContext context) {
        if (champ == null || champ.getFerme() == null) {
            return true;
        }

        double fermeSuperficie = champ.getFerme().getSuperficie();
        return champ.getSuperficie() <= 0.5 * fermeSuperficie;
    }
}

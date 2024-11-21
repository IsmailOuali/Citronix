package com.example.demo.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ChampSuperficieValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidChampSuperficie {
    String message() default "La superficie du champ dépasse 50% de la superficie totale de la ferme.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
package com.sporty.formula1bet.rest.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class OddsValidator implements ConstraintValidator<AllowedOdds, Integer> {

    private final Set<Integer> allowed = Set.of(2, 3, 4);

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && allowed.contains(value);
    }
}

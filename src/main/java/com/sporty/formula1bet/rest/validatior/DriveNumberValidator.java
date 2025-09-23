package com.sporty.formula1bet.rest.validatior;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class DriveNumberValidator implements ConstraintValidator<AllowedDriverNumber, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value != null && value > 0 && value < 100 && value != 17;
    }
}

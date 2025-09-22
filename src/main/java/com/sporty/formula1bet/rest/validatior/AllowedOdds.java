package com.sporty.formula1bet.rest.validatior;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Target({FIELD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OddsValidator.class)
public @interface AllowedOdds {

    String message() default "Odds must be only 2,3, or 4.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

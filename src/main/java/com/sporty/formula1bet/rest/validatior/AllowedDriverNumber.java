package com.sporty.formula1bet.rest.validatior;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

@Target({FIELD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DriveNumberValidator.class)
public @interface AllowedDriverNumber {

    /**
     *  The values of driver numbers in formula 1 can be from 2 to 99.
     *  The number 1 can be claimed form the reigning champion.
     *  The number 17 is retired.
     **/
    String message() default "Driver number must be an integer from 1 to 99 excluding 17.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

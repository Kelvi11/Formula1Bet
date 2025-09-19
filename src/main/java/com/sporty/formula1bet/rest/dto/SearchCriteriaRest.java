package com.sporty.formula1bet.rest.dto;

public record SearchCriteriaDto(
        String sessionType,
        Integer year,
        String countryCode) {

}

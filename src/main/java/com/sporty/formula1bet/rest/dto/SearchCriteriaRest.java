package com.sporty.formula1bet.rest.dto;

import lombok.Data;

@Data
public class SearchCriteriaRest {
    private final String sessionType;
    private final Integer year;
    private final String countryCode;
}

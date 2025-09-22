package com.sporty.formula1bet.rest.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BetRest {

    private String id;
    private Integer eventId;
    private Integer driverNumber;
    private BigDecimal amount;
    private Integer odds;
    private BigDecimal winningAmount;
}

package com.sporty.formula1bet.rest.dto;

import com.sporty.formula1bet.rest.validatior.AllowedOdds;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BetDataRest {

    @NotNull(message = "Event id is required.")
    @Positive(message = "Event id must be positive.")
    private Integer eventId;

    @NotNull(message = "Driver number is required.")
    @Min(value = 1, message = "Driver number must be at least 1.")
    private Integer driverNumber;

    @NotNull(message = "Amount is required.")
    @Positive(message = "Amount must be greater than 0.")
    private BigDecimal amount;

    @AllowedOdds
    private Integer odds;
}

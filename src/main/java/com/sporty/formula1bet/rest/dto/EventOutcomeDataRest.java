package com.sporty.formula1bet.rest.dto;

import com.sporty.formula1bet.rest.validatior.AllowedDriverNumber;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EventOutcomeDataRest {

    @NotNull
    private Integer eventId;

    @AllowedDriverNumber
    private Integer driverNumber;
}

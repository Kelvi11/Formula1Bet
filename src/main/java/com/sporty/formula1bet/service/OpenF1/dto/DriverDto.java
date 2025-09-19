package com.sporty.formula1bet.service.OpenF1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DriverDto {

    @JsonProperty("driver_number")
    private final int numberId;

    @JsonProperty("full_name")
    private final String fullName;

    @JsonProperty("session_key")
    private final int sessionKey;
}

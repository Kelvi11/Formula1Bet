package com.sporty.formula1bet.service.proxy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DriverDto {

    @JsonProperty("driver_number")
    private final int number;

    @JsonProperty("full_name")
    private final String fullName;

    @JsonProperty("session_key")
    private final int sessionKey;
}

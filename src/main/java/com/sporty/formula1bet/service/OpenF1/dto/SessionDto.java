package com.sporty.formula1bet.service.OpenF1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SessionDto {
    @JsonProperty("meeting_key")
    private int meetingKey;

    @JsonProperty("session_key")
    private int sessionKey;

    @JsonProperty("location")
    private String location;

    @JsonProperty("date_start")
    private String dateStart;

    @JsonProperty("date_end")
    private String dateEnd;

    @JsonProperty("session_type")
    private String sessionType;

    @JsonProperty("session_name")
    private String sessionName;

    @JsonProperty("country_key")
    private int countryKey;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("country_name")
    private String countryName;

    @JsonProperty("circuit_key")
    private int circuitKey;

    @JsonProperty("circuit_short_name")
    private String circuitShortName;

    @JsonProperty("gmt_offset")
    private String gmtOffset;

    @JsonProperty("year")
    private int year;
}

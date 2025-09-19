package com.sporty.formula1bet.rest.dto;

import lombok.Data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Data
public class EventDto {

    private int meetingKey;
    private int sessionKey;

    private String location;

    private Instant dateStart;
    private Instant dateEnd;

    private String sessionType;
    private String sessionName;

    private int countryKey;
    private String countryCode;
    private String countryName;

    private int circuitKey;
    private String circuitShortName;

    private String gmtOffset;
    private int year;

    private List<DriverRest> drivers = new ArrayList<>();
}

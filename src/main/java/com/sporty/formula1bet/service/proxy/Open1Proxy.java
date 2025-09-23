package com.sporty.formula1bet.service.proxy;

import com.sporty.formula1bet.service.proxy.dto.DriverDto;
import com.sporty.formula1bet.service.proxy.dto.SessionDto;

import java.util.List;

public interface Open1Proxy {

    List<SessionDto> sessions(String sessionType, Integer year, String countryCode);

    List<DriverDto> drivers();

    boolean doesSessionWithIdExists(int id);

    boolean doesDriverWithNumberExists(int eventId, int driverNumber);
}

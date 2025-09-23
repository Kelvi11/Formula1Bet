package com.sporty.formula1bet.service.proxy;

import com.sporty.formula1bet.rest.utils.UriUtils;
import com.sporty.formula1bet.service.proxy.dto.DriverDto;
import com.sporty.formula1bet.service.proxy.dto.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class Open1ProxyImpl implements Open1Proxy{

    private final WebClient webClient;

    @Override
    public List<SessionDto> sessions(String sessionType, Integer year, String countryCode) {
        Map<String, Object> params = new HashMap<>();
        params.put("session_type", sessionType);
        params.put("year", year);
        params.put("country_code", countryCode);

        return webClient.get()
                .uri(uriBuilder -> UriUtils.addQueryParams(uriBuilder.path("/sessions"), params).build())
                .retrieve()
                .bodyToFlux(SessionDto.class)
                .collectList()
                .block();
    }

    @Override
    public List<DriverDto> drivers() {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/drivers").build())
                .retrieve()
                .bodyToFlux(DriverDto.class)
                .collectList()
                .block();
    }

    @Override
    public boolean doesSessionWithIdExists(int id) {
        List<SessionDto> sessions = webClient.get()
                .uri(uriBuilder -> UriUtils.addQueryParams(uriBuilder.path("/sessions"), Map.of("session_key", id)).build())
                .retrieve()
                .bodyToFlux(SessionDto.class)
                .collectList()
                .block();

        return sessions != null && sessions.size() == 1;
    }

    @Override
    public boolean doesDriverWithNumberExists(int eventId, int driverNumber) {
        List<DriverDto> drivers = webClient.get()
                .uri(uriBuilder -> UriUtils.addQueryParams(uriBuilder.path("/drivers"), Map.of("driver_number", driverNumber, "session_key", eventId)).build())
                .retrieve()
                .bodyToFlux(DriverDto.class)
                .collectList()
                .block();

        return drivers != null && drivers.size() == 1;
    }
}

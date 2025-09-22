package com.sporty.formula1bet.service.OpenF1;

import com.sporty.formula1bet.mapper.DriverMapper;
import com.sporty.formula1bet.mapper.EventMapper;
import com.sporty.formula1bet.model.Driver;
import com.sporty.formula1bet.model.Event;
import com.sporty.formula1bet.rest.utils.UriUtils;
import com.sporty.formula1bet.service.EventService;
import com.sporty.formula1bet.service.OpenF1.dto.DriverDto;
import com.sporty.formula1bet.service.OpenF1.dto.SessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OpenF1Service implements EventService {

    private final EventMapper eventMapper;
    private final DriverMapper driverMapper;
    private final WebClient webClient;

    @Override
    public List<Event> events(String sessionType, Integer year, String countryCode) {

        Map<String, Object> params = new HashMap<>();
        params.put("session_type", sessionType);
        params.put("year", year);
        params.put("country_code", countryCode);

        List<Event> events = eventMapper.toEvents(
                webClient.get()
                    .uri(uriBuilder -> UriUtils.addQueryParams(uriBuilder.path("/sessions"), params).build())
                    .retrieve()
                    .bodyToFlux(SessionDto.class)
                    .collectList()
                    .block()
        );

        if (events == null){
            return new ArrayList<>();
        }

        List<Driver> drivers = driverMapper.toDrivers(
                webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/drivers").build())
                    .retrieve()
                    .bodyToFlux(DriverDto.class)
                    .collectList()
                    .block()
        );

        if (drivers == null){
            return events;
        }

        return enrichEventsWithDriversData(drivers, events);
    }

    private List<Event> enrichEventsWithDriversData(List<Driver> drivers, List<Event> events) {
        Map<Integer, List<Driver>> driversByEvent = drivers.stream().collect(Collectors.groupingBy(Driver::getSessionKey));

        events.forEach(event -> event.setDrivers(driversByEvent.getOrDefault(event.getId(), new ArrayList<>())));

        return events;
    }

    @Override
    public boolean exists(int id){
        List<SessionDto> sessionDtos = webClient.get()
                .uri(uriBuilder -> UriUtils.addQueryParams(uriBuilder.path("/sessions"), Map.of("session_key", id)).build())
                .retrieve()
                .bodyToFlux(SessionDto.class)
                .collectList()
                .block();

        return sessionDtos != null && sessionDtos.size() == 1;
    }
}

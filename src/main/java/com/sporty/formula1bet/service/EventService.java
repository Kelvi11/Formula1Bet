package com.sporty.formula1bet.service;

import com.sporty.formula1bet.model.Event;
import com.sporty.formula1bet.model.EventOutcome;

import java.util.List;

public interface EventService {

    List<Event> events(String sessionType, Integer year, String countryCode, int offset, int size);

    void outcome(EventOutcome eventOutcome) throws Exception;
}

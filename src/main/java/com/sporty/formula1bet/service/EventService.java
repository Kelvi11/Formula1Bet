package com.sporty.formula1bet.service;

import com.sporty.formula1bet.model.Event;

import java.util.List;

public interface EventService {

    List<Event> events(String sessionType, Integer year, String countryCode);
}

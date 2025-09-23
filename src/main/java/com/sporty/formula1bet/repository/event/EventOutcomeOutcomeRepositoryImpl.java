package com.sporty.formula1bet.repository.event;

import com.sporty.formula1bet.model.EventOutcome;
import com.sporty.formula1bet.repository.EventOutcomeRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class EventOutcomeOutcomeRepositoryImpl implements EventOutcomeRepository {

    Set<EventOutcome> eventOutcomes = new HashSet<>();

    @Override
    public EventOutcome save(EventOutcome eventOutcome) {
        eventOutcomes.add(eventOutcome);
        return eventOutcome;
    }
}

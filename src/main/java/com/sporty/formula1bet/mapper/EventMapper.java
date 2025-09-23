package com.sporty.formula1bet.mapper;

import com.sporty.formula1bet.model.Event;
import com.sporty.formula1bet.model.EventOutcome;
import com.sporty.formula1bet.rest.dto.EventOutcomeDataRest;
import com.sporty.formula1bet.rest.dto.EventRest;
import com.sporty.formula1bet.service.proxy.dto.SessionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventRest toRest(Event event);

    List<EventRest> toRest(List<Event> eventList);

    @Mapping(target = "id", source = "sessionKey")
    Event toEvent(SessionDto sessionDto);

    List<Event> toEvents(List<SessionDto> sessionDtos);

    EventOutcome toEventOutcome(EventOutcomeDataRest eventOutcomeDataRest);
}

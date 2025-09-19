package com.sporty.formula1bet.mapper;

import com.sporty.formula1bet.model.Event;
import com.sporty.formula1bet.rest.dto.EventRest;
import com.sporty.formula1bet.service.OpenF1.dto.SessionDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventRest toRest(Event event);

    List<EventRest> toRest(List<Event> eventList);

    Event toEvent(SessionDto sessionDto);

    List<Event> toEvents(List<SessionDto> sessionDtos);
}

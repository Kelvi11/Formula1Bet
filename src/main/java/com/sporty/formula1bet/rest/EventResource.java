package com.sporty.formula1bet.rest;

import com.sporty.formula1bet.mapper.EventMapper;
import com.sporty.formula1bet.rest.dto.EventRest;
import com.sporty.formula1bet.rest.dto.SearchCriteriaRest;
import com.sporty.formula1bet.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/events")
public class EventResource {

    private final EventMapper eventMapper;
    private final EventService eventService;

    @GetMapping
    public ResponseEntity<List<EventRest>> events(@ModelAttribute SearchCriteriaRest searchCriteria){
        return ResponseEntity.ok(
            eventMapper.toRest(
                eventService.events(
                    searchCriteria.getSessionType(),
                    searchCriteria.getYear(),
                    searchCriteria.getCountryCode()
                )
            )
        );
    }

    @PostMapping("/outcome")
    public ResponseEntity outcome(){
        return ResponseEntity.ok(List.of());
    }
}

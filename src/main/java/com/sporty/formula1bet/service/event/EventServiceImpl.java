package com.sporty.formula1bet.service.event;

import com.sporty.formula1bet.mapper.DriverMapper;
import com.sporty.formula1bet.mapper.EventMapper;
import com.sporty.formula1bet.model.*;
import com.sporty.formula1bet.repository.EventOutcomeRepository;
import com.sporty.formula1bet.service.BetService;
import com.sporty.formula1bet.service.EventService;
import com.sporty.formula1bet.service.UserBalanceService;
import com.sporty.formula1bet.service.proxy.Open1Proxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class EventServiceImpl implements EventService {

    private final EventMapper eventMapper;
    private final DriverMapper driverMapper;
    private final Open1Proxy open1Proxy;
    private final BetService betService;
    private final UserBalanceService userBalanceService;
    private final EventOutcomeRepository eventOutcomeRepository;

    @Override
    public List<Event> events(String sessionType, Integer year, String countryCode, int offset, int size) {

        List<Event> events = eventMapper.toEvents(
                open1Proxy.sessions(sessionType, year, countryCode)
        );

        if (events == null){
            return new ArrayList<>();
        }

        List<Driver> drivers = driverMapper.toDrivers(
                open1Proxy.drivers()
        );

        if (drivers == null){
            return events;
        }

        return paginate(enrichEventsWithDriversData(drivers, events), offset, size);
    }

    private List<Event> enrichEventsWithDriversData(List<Driver> drivers, List<Event> events) {
        Map<Integer, List<Driver>> driversByEvent = drivers.stream().collect(Collectors.groupingBy(Driver::getSessionKey));
        events.forEach(event -> event.setDrivers(driversByEvent.getOrDefault(event.getId(), new ArrayList<>())));
        return events;
    }


    private List<Event> paginate(List<Event> events, int offset, int size){
        return events.stream()
                .sorted(Comparator.comparing(Event::getDateStart).reversed())
                .skip(offset)
                .limit(size)
                .toList();
    }


    @Override
    public void outcome(EventOutcome eventOutcome) throws Exception {
        if (!open1Proxy.doesSessionWithIdExists(eventOutcome.getEventId())){
            String message = String.format("Event with id={%s} doesn't exits.", eventOutcome.getEventId());
            throw new Exception(message);
        }

        if (!open1Proxy.doesDriverWithNumberExists(eventOutcome.getEventId(), eventOutcome.getDriverNumber())){
            String message = String.format("Driver with number={%s} doesn't exits for event with id={%s}.", eventOutcome.getDriverNumber(), eventOutcome.getEventId());
            throw new Exception(message);
        }

        EventOutcome savedEventOutcome = eventOutcomeRepository.save(eventOutcome);
        log.info("{} was saved.", savedEventOutcome);

        List<Bet> winningBets = betService.winningBets(eventOutcome.getEventId(), eventOutcome.getDriverNumber());
        log.info("Winning bets are {}.", winningBets);

        winningBets.forEach(
                this::processBet
        );
    }

    private void processBet(Bet winningBet) {
        BigDecimal winningAmount = winningBet.winningAmount();
        UserBalance userBalance = userBalanceService.addBalance(winningBet.getUserId(), winningAmount);
        log.info("{} was increased by {}€.", userBalance, winningAmount);
    }
}

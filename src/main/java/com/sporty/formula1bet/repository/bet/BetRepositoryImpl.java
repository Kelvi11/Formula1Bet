package com.sporty.formula1bet.repository.bet;

import com.sporty.formula1bet.model.Bet;
import com.sporty.formula1bet.repository.BetRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Component
public class BetRepositoryImpl implements BetRepository {

    Map<String, Bet> bets = new HashMap<>();

    @Override
    public List<Bet> winningBets(int eventId, int driverNumber) {
        return bets.values()
                .stream()
                .filter(bet -> bet.getEventId() == eventId && bet.getDriverNumber() == driverNumber)
                .toList();
    }

    @Override
    public Bet save(Bet bet) {
        bets.put(bet.getId(), bet);
        return bet;
    }
}

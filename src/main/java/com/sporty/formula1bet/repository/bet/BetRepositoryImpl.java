package com.sporty.formula1bet.repository.bet;

import com.sporty.formula1bet.model.Bet;
import com.sporty.formula1bet.repository.BetRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class BetRepositoryImpl implements BetRepository {

    Map<String, Bet> bets = new HashMap<>();

    @Override
    public void save(Bet bet) {
        bets.put(bet.getId(), bet);
    }
}

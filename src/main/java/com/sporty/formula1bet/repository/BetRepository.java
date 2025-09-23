package com.sporty.formula1bet.repository;

import com.sporty.formula1bet.model.Bet;

import java.util.List;

public interface BetRepository {

    List<Bet> winningBets(int eventId, int driverNumber);

    Bet save(Bet bet);
}

package com.sporty.formula1bet.service;

import com.sporty.formula1bet.model.Bet;

import java.util.List;

public interface BetService {

    Bet placeBet(Integer userId, Bet bet) throws Exception;

    List<Bet> winningBets(int eventId, int driverNumber);
}

package com.sporty.formula1bet.service;

import com.sporty.formula1bet.model.Bet;

public interface BetService {

    Bet placeBet(Integer userId, Bet bet) throws Exception;
}

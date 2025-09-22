package com.sporty.formula1bet.service;

import java.math.BigDecimal;

public interface UserBalanceService {

    boolean hasEnoughFunds(int userId, BigDecimal amount);

    void subtractsBalance(int userId, BigDecimal amount);
}

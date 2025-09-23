package com.sporty.formula1bet.service;

import com.sporty.formula1bet.model.UserBalance;

import java.math.BigDecimal;

public interface UserBalanceService {

    BigDecimal getUserBalance(int userId);

    UserBalance subtractsBalance(int userId, BigDecimal amount);

    UserBalance addBalance(int userId, BigDecimal amount);
}

package com.sporty.formula1bet.repository;

import com.sporty.formula1bet.model.UserBalance;

public interface UserBalanceRepository {
    UserBalance getByUserId(int userId);

    UserBalance save(UserBalance userBalance);
}

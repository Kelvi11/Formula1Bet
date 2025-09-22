package com.sporty.formula1bet.repository.userbalance;

import com.sporty.formula1bet.model.UserBalance;
import com.sporty.formula1bet.repository.UserBalanceRepository;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class UserBalanceRepositoryImpl implements UserBalanceRepository {

    Map<Integer, UserBalance> userBalances = new HashMap<>();

    public UserBalanceRepositoryImpl() {
        this.userBalances.put(1, new UserBalance(1, new BigDecimal(100)));
        this.userBalances.put(2, new UserBalance(2, new BigDecimal(100)));
        this.userBalances.put(3, new UserBalance(3, new BigDecimal(100)));
    }

    @Override
    public UserBalance getByUserId(int userId){
        return userBalances.get(userId);
    }

    @Override
    public void save(UserBalance userBalance) {
        userBalances.put(userBalance.getUserId(), userBalance);
    }
}

package com.sporty.formula1bet.service.userbalance;

import com.sporty.formula1bet.model.UserBalance;
import com.sporty.formula1bet.repository.UserBalanceRepository;
import com.sporty.formula1bet.service.UserBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class UserBalanceServiceImpl implements UserBalanceService {

    private final UserBalanceRepository userBalanceRepository;

    @Override
    public boolean hasEnoughFunds(int userId, BigDecimal amount) {
        return userBalanceRepository.getByUserId(userId).getBalance().compareTo(amount) <= 0;
    }

    @Override
    public void subtractsBalance(int userId, BigDecimal amount){

        UserBalance userBalance = userBalanceRepository.getByUserId(userId);

        userBalance.setBalance(userBalance.getBalance().subtract(amount));

        userBalanceRepository.save(userBalance);
    }
}

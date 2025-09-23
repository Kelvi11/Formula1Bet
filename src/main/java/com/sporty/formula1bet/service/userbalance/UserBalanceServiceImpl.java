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
    public BigDecimal getUserBalance(int userId) {
        return userBalanceRepository.getByUserId(userId).getBalance();
    }

    @Override
    public UserBalance subtractsBalance(int userId, BigDecimal amount){

        UserBalance userBalance = userBalanceRepository.getByUserId(userId);

        userBalance.setBalance(userBalance.getBalance().subtract(amount));

        return userBalanceRepository.save(userBalance);
    }

    @Override
    public UserBalance addBalance(int userId, BigDecimal amount) {

        UserBalance userBalance = userBalanceRepository.getByUserId(userId);

        userBalance.setBalance(userBalance.getBalance().add(amount));

        return userBalanceRepository.save(userBalance);
    }
}

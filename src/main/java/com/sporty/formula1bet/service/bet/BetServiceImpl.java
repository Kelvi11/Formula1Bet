package com.sporty.formula1bet.service.bet;

import com.sporty.formula1bet.model.Bet;
import com.sporty.formula1bet.model.UserBalance;
import com.sporty.formula1bet.repository.BetRepository;
import com.sporty.formula1bet.service.BetService;
import com.sporty.formula1bet.service.UserBalanceService;
import com.sporty.formula1bet.service.proxy.Open1Proxy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Service
public class BetServiceImpl implements BetService {

    private final Open1Proxy open1Proxy;
    private final UserBalanceService userBalanceService;
    private final BetRepository betRepository;

    @Override
    public Bet placeBet(Integer userId, Bet bet) throws Exception {

        if (!open1Proxy.doesSessionWithIdExists(bet.getEventId())){
            String message = String.format("Event with id={%s} doesn't exits, bet={%s}", bet.getEventId(), bet);
            throw new Exception(message);
        }

        bet.setId(UUID.randomUUID().toString());
        bet.setAmount(bet.getAmount().setScale(2, RoundingMode.FLOOR));
        bet.setUserId(userId);

        BigDecimal currentBalance = userBalanceService.getUserBalance(userId);
        if (hasEnoughFunds(currentBalance, bet.getAmount())){
            String message = String.format("User with id={%s} doesn't have enough funds={%s}€ to place the bet={%s}", userId, currentBalance, bet);
            throw new Exception(message);
        }
        Bet savedBet = betRepository.save(bet);
        log.info("{} was saved.", savedBet);

        UserBalance userBalance = userBalanceService.subtractsBalance(userId, bet.getAmount());
        log.info("{} was decreased by {}€.", userBalance, bet.getAmount());

        return bet;
    }

    private boolean hasEnoughFunds(BigDecimal currentBalance, BigDecimal betAmount){
        return currentBalance.compareTo(betAmount) <= 0;
    }

    @Override
    public List<Bet> winningBets(int eventId, int driverNumber) {
        return betRepository.winningBets(eventId, driverNumber);
    }
}

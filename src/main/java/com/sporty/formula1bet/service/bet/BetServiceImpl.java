package com.sporty.formula1bet.service.bet;

import com.sporty.formula1bet.model.Bet;
import com.sporty.formula1bet.repository.BetRepository;
import com.sporty.formula1bet.service.BetService;
import com.sporty.formula1bet.service.EventService;
import com.sporty.formula1bet.service.UserBalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BetServiceImpl implements BetService {

    private final EventService eventService;
    private final UserBalanceService userBalanceService;
    private final BetRepository betRepository;

    @Override
    public Bet placeBet(Integer userId, Bet bet) throws Exception {

        if (!eventService.exists(bet.getEventId())){
            String message = String.format("Event with id={%s} doesn't exits bet={%s}", bet.getEventId(), bet);
            throw new Exception(message);
        }

        bet.setId(UUID.randomUUID().toString());
        bet.setAmount(bet.getAmount().setScale(2, RoundingMode.FLOOR));

        if (userBalanceService.hasEnoughFunds(userId, bet.getAmount())){
            String message = String.format("User with id={%s} doesn't have enough funds to place the bet={%s}", userId, bet);
            throw new Exception(message);
        }

        userBalanceService.subtractsBalance(userId, bet.getAmount());

        betRepository.save(bet);

        return bet;
    }
}

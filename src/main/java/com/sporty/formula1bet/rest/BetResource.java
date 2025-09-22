package com.sporty.formula1bet.rest;

import com.sporty.formula1bet.mapper.BetMapper;
import com.sporty.formula1bet.rest.dto.BetDataRest;
import com.sporty.formula1bet.rest.dto.BetRest;
import com.sporty.formula1bet.rest.exception.UnauthorizedException;
import com.sporty.formula1bet.service.BetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/bets")
public class BetResource {

    private final BetMapper betMapper;
    private final BetService betService;

    @PostMapping
    public ResponseEntity<BetRest> placeBet(
            @RequestHeader(value = "userId", required = false) Integer userId,
            @Valid @RequestBody BetDataRest betDataRest) throws Exception {

        if (userId == null){
            throw new UnauthorizedException("Unauthorized");
        }

        return ResponseEntity.ok(
            betMapper.toRest(
                betService.placeBet(userId, betMapper.toBet(betDataRest))
            )
        );
    }
}

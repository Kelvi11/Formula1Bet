package com.sporty.formula1bet.mapper;

import com.sporty.formula1bet.model.Bet;
import com.sporty.formula1bet.rest.dto.BetDataRest;
import com.sporty.formula1bet.rest.dto.BetRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BetMapper {

    @Mapping(target = "id", ignore = true)
    Bet toBet(BetDataRest betDataRest);

    @Mapping(target = "winningAmount", expression = "java(bet.winningAmount())")
    BetRest toRest(Bet bet);
}

package com.sporty.formula1bet.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Bet {

    /**
     * The id of the bet.
     */
    private String id;

    /**
     * The id of the event .
     */
    private int eventId;

    /**
     * The number of the driver predicted to win the race.
     */
    private int driverNumber;

    /**
     * The amount of bet placed in EURO rounded to the floor of two decimal points.
     * Example €2.46849 will be €2.46 .
     */
    private BigDecimal amount;

    /**
     * The odds of the bet, allowed values are only 2,3, or 4.
     */
    private int odds;

    public BigDecimal winningAmount(){
        return amount.multiply(BigDecimal.valueOf(odds));
    }
}

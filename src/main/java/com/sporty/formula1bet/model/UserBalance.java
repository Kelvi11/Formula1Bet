package com.sporty.formula1bet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
public class UserBalance {
    private int userId;
    private BigDecimal balance;
}

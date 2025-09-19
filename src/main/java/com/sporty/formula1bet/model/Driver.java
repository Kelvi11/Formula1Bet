package com.sporty.formula1bet.model;

import lombok.Getter;

import java.util.List;
import java.util.Random;

@Getter
public class Driver {

    private final int numberId;
    private final String fullName;
    private final int sessionKey;
    private final int odds;

    public Driver(int numberId, String fullName, int sessionKey) {
        this.numberId = numberId;
        this.fullName = fullName;
        this.sessionKey = sessionKey;
        this.odds = odds();
    }

    private int odds(){
        final List<Integer> options = List.of(2, 3, 4);
        int index = new Random().nextInt(options.size());
        return options.get(index);
    }
}

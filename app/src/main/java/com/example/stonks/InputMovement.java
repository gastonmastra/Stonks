package com.example.stonks;

import com.example.stonks.database.daos.entities.Movement;

public class InputMovement extends Movement {
    public InputMovement() {
        super();
    }

    @Override
    public double getResult(){
        return getBeforeAmount() + getAmount();
    }
}

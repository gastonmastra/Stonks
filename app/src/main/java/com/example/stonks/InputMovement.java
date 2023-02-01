package com.example.stonks;

public class InputMovement extends Movement {
    public InputMovement(String description, double amount, double beforeAmount, Clasification clasification) {
        super(description, amount, beforeAmount, clasification);
    }

    @Override
    public double getResult(){
        return BeforeAmount + Amount;
    }
}

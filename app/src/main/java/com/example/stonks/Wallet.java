package com.example.stonks;

import java.util.List;

public class Wallet {
    double Money;
    String Name;

    List<Movement> Movements;
    List<FixedExpense> FixedExpenses;

    public Wallet(){}

    public double getActualAmount(){
        return Money;
    }

    public Movement createMovement(String description, double amount, Clasification clasification){
        Movement movement =  new Movement(description, amount, Money, clasification);
        Movements.add(movement);
        return movement;
    }
}

package com.example.stonks.controllers;

import com.example.stonks.database.entities.Clasification;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.entities.Wallet;
import com.example.stonks.views.RegisterExpense;

import java.util.Date;

public class RegisterExpenseController {
    String Description;
    boolean IsDebt;
    double Amount;
    Wallet Wallet;
    RegisterExpense Screen;
    Date Date;
    String[] Clasifications;
    com.example.stonks.database.entities.Clasification Clasification;

    public RegisterExpenseController(RegisterExpense screen){
        Screen = screen;
        Date = new Date();
        //Esto debe recibirse por parametro cuando se crea la activity
        Wallet = new Wallet();
        Clasifications = new String[]{
                "Comida",
                "Salida",
                "Auto",
                "Ropa"
        };
        Screen.showClasifications(Clasifications);
    }

    public Movement Register(String description, double amount, String clasification){
        Description = description;
        Amount = amount;
        Clasification = new Clasification(){};
        validateInfo();
        return Wallet.createMovement(Description, Amount, Clasification);

    }


    private void validateInfo(){
    }


}

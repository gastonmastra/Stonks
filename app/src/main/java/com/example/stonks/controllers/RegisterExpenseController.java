package com.example.stonks.controllers;

import com.example.stonks.database.entities.Clasification;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.database.repository.room.MovementRepositoryRoom;
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
    IMovementRepository _movementRepository;

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

    public Movement Register(String description, double amount){
        Description = description;
        Amount = amount;
        validateInfo();
        Movement movement = Wallet.createMovement(Description, Amount);

        return movement;

    }


    private void validateInfo(){
    }


}

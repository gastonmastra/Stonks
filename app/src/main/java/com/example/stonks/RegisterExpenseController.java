package com.example.stonks;

import java.util.Date;

public class RegisterExpenseController {
    String Description;
    boolean IsDebt;
    double Amount;
    Wallet Wallet;
    RegisterExpense Screen;
    Date Date;
    String[] Clasifications;
    Clasification Clasification;

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

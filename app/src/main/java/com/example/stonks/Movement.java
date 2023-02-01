package com.example.stonks;

import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Date;


public class Movement {
    String Description;
    boolean IsDebt;
    double Amount;
    double BeforeAmount;
    Date date;

    Clasification Clasification;
    @Nullable
    Person Person;

    public Movement(String description, double amount, double beforeAmount, Clasification clasification){
    Description = description;
    Amount = amount;
    BeforeAmount = beforeAmount;
    Clasification = clasification;
    date = new Date();
    }

    public double getResult(){
        return BeforeAmount - Amount;
    }

}

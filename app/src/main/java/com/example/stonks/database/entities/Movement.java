package com.example.stonks.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Movement {
    @PrimaryKey( autoGenerate = true )
    @ColumnInfo(
            name = "movement_id"
    )
    private int MovementId;
    private String Description;

    private boolean Debt;
    private double Amount;
    private double BeforeAmount;
    private Date Date;

    public Movement(){ }

    public void setMovementId(int movementId) {
        MovementId = movementId;
    }

    public int getMovementId() {
        return MovementId;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public double getBeforeAmount() {
        return BeforeAmount;
    }

    public void setBeforeAmount(double beforeAmount) {
        BeforeAmount = beforeAmount;
    }

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }


    public double getResult(){
        return getBeforeAmount() - getAmount();
    }

    public String getDescription(){
        return this.Description;
    }

    public void setDebt(boolean debt) {
        Debt = debt;
    }

    public boolean isDebt() {
        return Debt;
    }
}

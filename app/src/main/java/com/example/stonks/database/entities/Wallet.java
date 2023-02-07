package com.example.stonks.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(tableName = "Wallets")
public class Wallet {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "wallet_id")
    private int WalletId;
    private double Money;
    private String Name;

    private List<Movement> Movements;
    private List<FixedExpense> FixedExpenses;

    public Wallet(){
        setMovements(new ArrayList<Movement>());
    }

    public double getActualAmount(){
        return getMoney();
    }

    public Movement createMovement(String description, double amount, Clasification clasification){
        Movement movement =  new Movement();
        movement.setDescription(description);
        movement.setAmount(amount);
        getMovements().add(movement);
        return movement;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public List<Movement> getMovements() {
        return Movements;
    }

    public void setMovements(List<Movement> movements) {
        Movements = movements;
    }

    public List<FixedExpense> getFixedExpenses() {
        return FixedExpenses;
    }

    public void setFixedExpenses(List<FixedExpense> fixedExpenses) {
        FixedExpenses = fixedExpenses;
    }
}

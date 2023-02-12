package com.example.stonks.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

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

    public Wallet() { }

    public double getActualAmount(){
        return getMoney();
    }

    public Movement createMovement(String description, double amount){
        Movement movement =  new Movement();
        movement.setDescription(description);
        movement.setAmount(amount);

        return movement;
    }

    public int getWalletId() {
        return WalletId;
    }

    public void setWalletId(int walletId) {
        WalletId = walletId;
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
}

package com.example.stonks.database.repository.room.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Wallets")
public class Wallet {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "wallet_id")
    public int walletId;
    public double money;
    public String name;

    public Wallet() { }

    public double getActualAmount(){
        return getMoney();
    }

    public Movement createMovement(String description, double amount, long classificationId, long walletId){
        Movement movement =  new Movement();
        movement.setDescription(description);
        movement.setAmount(amount);
        movement.setClassificationId(classificationId);
        movement.setWalletId(walletId);
        movement.setBeforeAmount(getMoney());
        movement.setDate(new Date());
        setMoney(getMoney() - amount);
        return movement;
    }

    public int getWalletId() {
        return walletId;
    }

    public void setWalletId(int walletId) {
        this.walletId = walletId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String toString(){
        return getName();
    }
}

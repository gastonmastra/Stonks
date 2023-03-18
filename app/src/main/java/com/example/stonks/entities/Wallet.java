package com.example.stonks.entities;

import androidx.annotation.NonNull;

import java.util.Date;

public class Wallet {

    private int walletId;
    private double money;
    private String name;

    public Wallet() { }

    public Movement createMovement(String description, double amount, Classification classification){
        Movement movement =  new Movement();
        movement.setDescription(description);
        movement.setAmount(amount);
        movement.setWallet(this);
        movement.setBeforeAmount(getMoney());
        movement.setDate(new Date());
        movement.setClassification(classification);
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

    public double getActualAmount(){
        return getMoney();
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

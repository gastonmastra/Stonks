package com.example.stonks.entities;

import java.util.Date;

public class Movement {
    private Long MovementId;
    private Wallet Wallet;
    private String Description;
    private boolean Debt;
    private double Amount;
    private double BeforeAmount;
    private Date Date;
    private Classification classification;
    private String entryId;

    public Movement(){ }

    public void setMovementId(Long movementId) {
        MovementId = movementId;
    }

    public Long getMovementId() {
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

    public com.example.stonks.entities.Wallet getWallet() {
        return Wallet;
    }

    public void setWallet(com.example.stonks.entities.Wallet wallet) {
        Wallet = wallet;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    public String getEntryId() {
        return entryId;
    }

    public void setEntryId(String entryId) {
        this.entryId = entryId;
    }
}
package com.example.stonks.database.daos.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(
        tableName = "Movements",
        foreignKeys = {
                @ForeignKey(
                        entity = Wallet.class,
                        parentColumns = "wallet_id",
                        childColumns = "wallet_id"
                ),
                @ForeignKey(
                        entity = Classification.class,
                        parentColumns = "classification_id",
                        childColumns = "classification_id"
                )
        }
)
public class Movement {
    @PrimaryKey( autoGenerate = true ) @ColumnInfo( name = "movement_id" ) private int MovementId;
    @ColumnInfo( name = "wallet_id" ) private int WalletId;
    @ColumnInfo( name = "classification_id" ) private int ClassificationId;
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

    public int getWalletId() {
        return WalletId;
    }

    public void setWalletId(int walletId) {
        WalletId = walletId;
    }

    public int getClassificationId() {
        return ClassificationId;
    }

    public void setClassificationId(int classificationId) {
        ClassificationId = classificationId;
    }
}
package com.example.stonks.database.repository.room.entities;

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
    //@PrimaryKey( autoGenerate = true ) @ColumnInfo( name = "movement_id" )
    private Long MovementId;
    //@ColumnInfo( name = "wallet_id" )
    private Wallet Wallet;
    //@ColumnInfo( name = "classification_id", defaultValue = "NULL") private Long ClassificationId;
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

    public com.example.stonks.database.repository.room.entities.Wallet getWallet() {
        return Wallet;
    }

    public void setWallet(com.example.stonks.database.repository.room.entities.Wallet wallet) {
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
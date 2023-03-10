package com.example.stonks.database.repository.room.entities;

import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Fixed_Expense_Detail")
public class FixedExpenseDetail {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fixed_expense_detail_id")
    public int FixedExpenseDetailId;
    public Date Date;
    @Nullable
    public Date DateOfPayment;
    public Double Mount;
    public Boolean Payed;

    public FixedExpenseDetail(){}

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Nullable
    public java.util.Date getDateOfPayment() {
        return DateOfPayment;
    }

    public void setDateOfPayment(@Nullable java.util.Date dateOfPayment) {
        DateOfPayment = dateOfPayment;
    }

    public Double getMount() {
        return Mount;
    }

    public void setMount(Double mount) {
        Mount = mount;
    }

    public Boolean getPayed() {
        return Payed;
    }

    public void setPayed(Boolean payed) {
        Payed = payed;
    }

    public int getFixedExpenseDetailId() {
        return FixedExpenseDetailId;
    }

    public void setFixedExpenseDetailId(int fixedExpenseDetailId) {
        FixedExpenseDetailId = fixedExpenseDetailId;
    }
}

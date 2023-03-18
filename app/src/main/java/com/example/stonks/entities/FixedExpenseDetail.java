package com.example.stonks.entities;

import androidx.annotation.Nullable;

import java.util.Date;

public class FixedExpenseDetail {
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
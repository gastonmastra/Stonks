package com.example.stonks.database.entities;

import androidx.annotation.Nullable;

import java.util.Date;

public class FixedExpenseDetail {
    private Date Date;
    @Nullable
    private
    Date DatefPayment;
    private Double Mount;
    private Boolean Payed;

    @Nullable
    private
    Person Person;

    public FixedExpenseDetail(){}

    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    @Nullable
    public java.util.Date getDatefPayment() {
        return DatefPayment;
    }

    public void setDatefPayment(@Nullable java.util.Date datefPayment) {
        DatefPayment = datefPayment;
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

    @Nullable
    public com.example.stonks.database.entities.Person getPerson() {
        return Person;
    }

    public void setPerson(@Nullable com.example.stonks.database.entities.Person person) {
        Person = person;
    }
}

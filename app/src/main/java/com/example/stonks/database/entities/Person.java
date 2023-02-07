package com.example.stonks.database.entities;

import androidx.annotation.Nullable;

public class Person {
    private String Name;
    private String Surname;
    private Double Debt;

    public Person(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Double getDebt() {
        return Debt;
    }

    public void setDebt(Double debt) {
        Debt = debt;
    }
}

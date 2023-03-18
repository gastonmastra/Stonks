package com.example.stonks.entities;

public class FixedExpense {
    public int FixedExpenseId;
    public String Description;
    public String Name;


    public FixedExpense(){}

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getFixedExpenseId() {
        return FixedExpenseId;
    }

    public void setFixedExpenseId(int fixedExpenseId) {
        FixedExpenseId = fixedExpenseId;
    }
}

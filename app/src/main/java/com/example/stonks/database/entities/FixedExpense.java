package com.example.stonks.database.entities;

public class FixedExpense {
    private String Description;
    private String Name;

    private FixedExpenseDetail[] FixedExpenseDetail;

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

    public com.example.stonks.database.entities.FixedExpenseDetail[] getFixedExpenseDetail() {
        return FixedExpenseDetail;
    }

    public void setFixedExpenseDetail(com.example.stonks.database.entities.FixedExpenseDetail[] fixedExpenseDetail) {
        FixedExpenseDetail = fixedExpenseDetail;
    }
}

package com.example.stonks.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Fixed_Expenses")
public class FixedExpense {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fixed_expense_id")
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

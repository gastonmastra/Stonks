package com.example.stonks.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Fixed_Expenses")
public class FixedExpense {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "fixed_expense_id")
    private int FixedExpenseId;
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
    public int getFixedExpenseId() {
        return FixedExpenseId;
    }

    public void setFixedExpenseId(int fixedExpenseId) {
        FixedExpenseId = fixedExpenseId;
    }
}

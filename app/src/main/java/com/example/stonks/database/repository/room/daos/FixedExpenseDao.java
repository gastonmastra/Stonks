package com.example.stonks.database.repository.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.repository.room.entities.FixedExpense;

@Dao
public interface FixedExpenseDao {
    @Query("SELECT * FROM Fixed_Expenses WHERE fixed_expense_id = :fixedExpenseId")
    FixedExpense getFixedExpense(int fixedExpenseId);
    @Insert
    void insertFixedExpense(FixedExpense fixedExpense);
    @Update
    void updateFixedExpense(FixedExpense fixedExpense);
    @Delete
    void deleteFixedExpense(FixedExpense fixedExpense);
}

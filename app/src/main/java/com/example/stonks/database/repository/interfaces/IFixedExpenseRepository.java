package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.entities.FixedExpense;

public interface IFixedExpenseRepository {
    FixedExpense getFixedExpense(int fixedExpenseId);
    void insertFixedExpense(FixedExpense fixedExpense);
    void updateFixedExpense(FixedExpense fixedExpense);
    void deleteFixedExpense(FixedExpense fixedExpense);
}

package com.example.stonks.database.repository.firebase;

import com.example.stonks.database.repository.room.entities.FixedExpense;
import com.example.stonks.database.repository.interfaces.IFixedExpenseRepository;

public class FixedExpenseRepositoryFirebase implements IFixedExpenseRepository {
    private static FixedExpenseRepositoryFirebase instance;

    public static FixedExpenseRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new FixedExpenseRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public FixedExpense getFixedExpense(int fixedExpenseId) {
        return null;
    }

    @Override
    public void insertFixedExpense(FixedExpense fixedExpense) {

    }

    @Override
    public void updateFixedExpense(FixedExpense fixedExpense) {

    }

    @Override
    public void deleteFixedExpense(FixedExpense fixedExpense) {

    }
}

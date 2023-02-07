package com.example.stonks.database.repository;

import com.example.stonks.database.daos.FixedExpenseDao;
import com.example.stonks.database.entities.FixedExpense;
import com.example.stonks.database.repository.interfaces.IFixedExpenseRepository;

public class FixedExpenseRepositoryRoom implements IFixedExpenseRepository {
    FixedExpenseDao dao;

    public FixedExpenseRepositoryRoom(FixedExpenseDao dao) {
        this.dao = dao;
    }

    @Override
    public FixedExpense getFixedExpense(int fixedExpenseId) {
        return dao.getFixedExpense(fixedExpenseId);
    }

    @Override
    public void insertFixedExpense(FixedExpense fixedExpense) {
        dao.insertFixedExpense(fixedExpense);
    }

    @Override
    public void updateFixedExpense(FixedExpense fixedExpense) {
        dao.updateFixedExpense(fixedExpense);
    }

    @Override
    public void deleteFixedExpense(FixedExpense fixedExpense) {
        dao.deleteFixedExpense(fixedExpense);
    }
}

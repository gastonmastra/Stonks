package com.example.stonks.database.repository.room;

import com.example.stonks.database.daos.FixedExpenseDao;
import com.example.stonks.database.daos.entities.FixedExpense;
import com.example.stonks.database.repository.interfaces.IFixedExpenseRepository;

public class FixedExpenseRepositoryRoom implements IFixedExpenseRepository {
    private static FixedExpenseRepositoryRoom instance;
    private final FixedExpenseDao dao;

    private FixedExpenseRepositoryRoom(FixedExpenseDao dao) {
        this.dao = dao;
    }


    public static FixedExpenseRepositoryRoom getInstance(FixedExpenseDao dao){
        if (instance == null){
            instance = new FixedExpenseRepositoryRoom(dao);
        }
        return instance;
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

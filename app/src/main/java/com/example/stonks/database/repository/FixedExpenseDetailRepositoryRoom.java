package com.example.stonks.database.repository;

import com.example.stonks.database.daos.FixedExpenseDetailDao;
import com.example.stonks.database.entities.FixedExpenseDetail;
import com.example.stonks.database.repository.interfaces.IFixedExpenseDetailRepository;

public class FixedExpenseDetailRepositoryRoom implements IFixedExpenseDetailRepository {
    FixedExpenseDetailDao dao;

    public FixedExpenseDetailRepositoryRoom(FixedExpenseDetailDao dao) {
        this.dao = dao;
    }

    @Override
    public FixedExpenseDetail getFixedExpenseDetail(int fixedExpenseDetailId) {
        return dao.getFixedExpenseDetail(fixedExpenseDetailId);
    }

    @Override
    public void insertFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail) {
        dao.insertFixedExpenseDetail(fixedExpenseDetail);
    }

    @Override
    public void updateFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail) {
        dao.updateFixedExpenseDetail(fixedExpenseDetail);
    }

    @Override
    public void deleteFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail) {
        dao.deleteFixedExpenseDetail(fixedExpenseDetail);
    }
}

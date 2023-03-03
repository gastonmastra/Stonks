package com.example.stonks.database.repository.room;

import com.example.stonks.database.repository.room.daos.FixedExpenseDetailDao;
import com.example.stonks.database.repository.room.entities.FixedExpenseDetail;
import com.example.stonks.database.repository.interfaces.IFixedExpenseDetailRepository;

public class FixedExpenseDetailRepositoryRoom implements IFixedExpenseDetailRepository {
    private static FixedExpenseDetailRepositoryRoom instance;
    private final FixedExpenseDetailDao dao;

    private FixedExpenseDetailRepositoryRoom(FixedExpenseDetailDao dao) {
        this.dao = dao;
    }

    public static FixedExpenseDetailRepositoryRoom getInstance(FixedExpenseDetailDao dao){
        if (instance == null){
            instance = new FixedExpenseDetailRepositoryRoom(dao);
        }
        return instance;
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

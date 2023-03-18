package com.example.stonks.database.repository.firebase;

import com.example.stonks.entities.FixedExpenseDetail;
import com.example.stonks.database.repository.interfaces.IFixedExpenseDetailRepository;

public class FixedExpenseDetailFirebase implements IFixedExpenseDetailRepository {
    private static FixedExpenseDetailFirebase instance;

    public static FixedExpenseDetailFirebase getInstance(){
        if (instance == null){
            instance = new FixedExpenseDetailFirebase();
        }
        return instance;
    }
    @Override
    public FixedExpenseDetail getFixedExpenseDetail(int fixedExpenseDetailId) {
        return null;
    }

    @Override
    public void insertFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail) {

    }

    @Override
    public void updateFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail) {

    }

    @Override
    public void deleteFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail) {

    }
}

package com.example.stonks.database.repository.interfaces;

import com.example.stonks.entities.FixedExpenseDetail;

public interface IFixedExpenseDetailRepository {
    FixedExpenseDetail getFixedExpenseDetail(int fixedExpenseDetailId);
    void insertFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail);
    void updateFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail);
    void deleteFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail);
}

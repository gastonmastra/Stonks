package com.example.stonks.database.repository.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.repository.room.entities.FixedExpenseDetail;

@Dao
public interface FixedExpenseDetailDao {
    @Query("SELECT * FROM FIXED_EXPENSE_DETAIL WHERE fixed_expense_detail_id = :fixedExpenseDetailId")
    FixedExpenseDetail getFixedExpenseDetail(int fixedExpenseDetailId);
    @Insert
    void insertFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail);
    @Update
    void updateFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail);
    @Delete
    void deleteFixedExpenseDetail(FixedExpenseDetail fixedExpenseDetail);

}

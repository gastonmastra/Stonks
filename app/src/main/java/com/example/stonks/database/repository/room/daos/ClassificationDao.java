package com.example.stonks.database.repository.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.repository.room.entities.Classification;

import java.util.List;

@Dao
public interface ClassificationDao {
    @Query("SELECT * FROM Classifications")
    List<Classification> getClassifications();
    @Query("SELECT * FROM Classifications WHERE classification_id = :classificationId")
    Classification getClassification(int classificationId);
    @Insert
    void insertClassification(Classification classification);
    @Delete
    void deleteClassification(Classification classification);
    @Update
    void updateClassification(Classification classification);
}

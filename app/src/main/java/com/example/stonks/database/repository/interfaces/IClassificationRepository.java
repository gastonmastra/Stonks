package com.example.stonks.database.repository.interfaces;

import androidx.lifecycle.LiveData;

import com.example.stonks.database.entities.Classification;

import java.util.List;

public interface IClassificationRepository {
    LiveData<List<Classification>> getAllClassifications();
    Classification getClassification(int classificationId);
    void insertClassification(Classification classification);
    void deleteClassification(Classification classification);
    void updateClassification(Classification classification);
}

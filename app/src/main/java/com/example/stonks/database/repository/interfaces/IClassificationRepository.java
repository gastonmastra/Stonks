package com.example.stonks.database.repository.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.room.entities.Classification;

import java.util.List;

public interface IClassificationRepository {
    MutableLiveData<List<Classification>> getAllClassifications();
    Classification getClassification(String name);
    void insertClassification(Classification classification);
    void deleteClassification(Classification classification);
    void updateClassification(Classification classification);
}

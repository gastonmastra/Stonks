package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.entities.Classification;

import java.util.List;

public interface IClasificationRepository {
    List<Classification> getAllClasifications();
    Classification getClasification(int clasificationId);
    void insertClasification(Classification clasification);
    void deleteClasification(Classification clasification);
    void updateClasification(Classification clasification);
}

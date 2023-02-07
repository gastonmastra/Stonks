package com.example.stonks.database.repository;

import com.example.stonks.database.entities.Clasification;

import java.util.List;

public interface IClasificationRepository {
    List<Clasification> getAllClasifications();
    Clasification getClasification(int clasificationId);
    void insertClasification(Clasification clasification);
    void deleteClasification(Clasification clasification);
    void updateClasification(Clasification clasification);
}

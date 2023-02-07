package com.example.stonks.database.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.stonks.database.entities.Clasification;
import com.example.stonks.database.entities.Movement;

import java.util.List;

@Dao
public interface MovementDao {
    @Query("SELECT * FROM Movement")
    List<Movement> getMovements();

    @Query("SELECT * FROM Movement WHERE Amount BETWEEN minAmount AND maxAmount")
    List<Movement> getMovementsBetween(double minAmount, double maxAmount);

    @Query("SELECT * FROM Movement WHERE Clasification = :clasification")
    List<Movement> getMovementsOfClasification(Clasification clasification);

}

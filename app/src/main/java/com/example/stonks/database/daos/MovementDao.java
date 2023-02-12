package com.example.stonks.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.entities.Clasification;
import com.example.stonks.database.entities.Movement;

import java.util.List;

@Dao
public interface MovementDao {
    @Query("SELECT * FROM Movement")
    List<Movement> getMovements();
    @Query("SELECT * FROM Movement WHERE movement_id = :movementId")
    Movement getMovement(int movementId);
    @Insert
    void insertMovement(Movement movement);
    @Update
    void updateMovement(Movement movement);
    @Delete
    void deleteMovement(Movement movement);

}

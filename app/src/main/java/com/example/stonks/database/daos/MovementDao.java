package com.example.stonks.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.daos.entities.Movement;

import java.util.List;

@Dao
public interface MovementDao {
    @Query("SELECT * FROM Movements")
    List<Movement> getMovements();
    @Query("SELECT * FROM Movements WHERE movement_id = :movementId")
    Movement getMovement(int movementId);
    @Insert
    void insertMovement(Movement movement);
    @Update
    void updateMovement(Movement movement);
    @Delete
    void deleteMovement(Movement movement);

}

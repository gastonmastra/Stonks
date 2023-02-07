package com.example.stonks.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.entities.Clasification;

import java.util.List;

@Dao
public interface ClasificationDao {
    @Query("SELECT * FROM Clasifications")
    List<Clasification> getClasifications();
    @Query("SELECT * FROM Clasifications WHERE clasification_id = :clasificationId")
    Clasification getClasification(int clasificationId);
    @Insert
    void insertClasification(Clasification clasification);
    @Delete
    void deleteClasification(Clasification clasification);
    @Update
    void updateClasification(Clasification clasification);
}

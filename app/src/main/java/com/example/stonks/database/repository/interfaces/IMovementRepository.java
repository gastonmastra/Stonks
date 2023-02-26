package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.repository.room.entities.Movement;

import java.util.List;

public interface IMovementRepository {
    List<Movement> getAllMovements();
    Movement getMovement(int movementId);
    void insertMovement(Movement movement);
    void updateMovement(Movement movement);
    void deleteMovement(Movement movement);
}

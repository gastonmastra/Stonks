package com.example.stonks.database.repository.firebase;

import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.interfaces.IMovementRepository;

import java.util.List;

public class MovementRepositoryFirebase implements IMovementRepository {

    private static MovementRepositoryFirebase instance;
    public static MovementRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new MovementRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public List<Movement> getAllMovements() {
        return null;
    }

    @Override
    public Movement getMovement(int movementId) {
        return null;
    }

    @Override
    public void insertMovement(Movement movement) {

    }

    @Override
    public void updateMovement(Movement movement) {

    }

    @Override
    public void deleteMovement(Movement movement) {

    }
}

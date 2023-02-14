package com.example.stonks.database.repository.room;

import com.example.stonks.database.daos.MovementDao;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.repository.interfaces.IMovementRepository;

import java.util.List;

public class MovementRepositoryRoom implements IMovementRepository {
    private static MovementRepositoryRoom instance;
    private final MovementDao dao;

    private MovementRepositoryRoom(MovementDao dao) {
        this.dao = dao;
    }

    public static MovementRepositoryRoom getInstance(MovementDao dao){
        if (instance == null){
            instance = new MovementRepositoryRoom(dao);
        }
        return instance;
    }

    @Override
    public List<Movement> getAllMovements() {
        return dao.getMovements();
    }

    @Override
    public Movement getMovement(int movementId) {
        return dao.getMovement(movementId);
    }

    @Override
    public void insertMovement(Movement movement) {
        dao.insertMovement(movement);
    }

    @Override
    public void updateMovement(Movement movement) {
        dao.updateMovement(movement);
    }

    @Override
    public void deleteMovement(Movement movement) {
        dao.deleteMovement(movement);
    }
}

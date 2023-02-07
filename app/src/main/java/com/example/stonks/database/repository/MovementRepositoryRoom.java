package com.example.stonks.database.repository;

import com.example.stonks.database.daos.MovementDao;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.repository.interfaces.IMovementRepository;

import java.util.List;

public class MovementRepositoryRoom implements IMovementRepository {
    MovementDao dao;

    public MovementRepositoryRoom(MovementDao dao) {
        this.dao = dao;
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

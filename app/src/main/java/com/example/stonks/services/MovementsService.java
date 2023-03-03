package com.example.stonks.services;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.services.interfaces.IMovementsService;

import java.util.List;

public class MovementsService implements IMovementsService {
    IMovementRepository movementRepository;

    public MovementsService(IMovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public Movement getMovement(int id) {
        return movementRepository.getMovement(id);
    }

    @Override
    public MutableLiveData<List<Movement>> getMovements() {
        return movementRepository.getAllMovements();
    }

    @Override
    public void insertMovement(Movement movement) {
        movementRepository.insertMovement(movement);
    }

    @Override
    public void updateMovement(Movement movement) {
        movementRepository.updateMovement(movement);
    }

    @Override
    public void deleteMovement(Movement movement) {
        movementRepository.deleteMovement(movement);
    }

    @Override
    public void getMovementsOfWallet(Wallet wallet) {
        movementRepository.getMovementOfWallet(wallet);
    }
}

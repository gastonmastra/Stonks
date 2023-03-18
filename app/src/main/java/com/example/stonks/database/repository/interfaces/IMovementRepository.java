package com.example.stonks.database.repository.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.entities.Movement;
import com.example.stonks.entities.Wallet;

import java.util.List;

public interface IMovementRepository {
    MutableLiveData<List<Movement>> getAllMovements();
    Movement getMovement(int movementId);
    void insertMovement(Movement movement);
    void updateMovement(Movement movement);
    void deleteMovement(Movement movement);

    MutableLiveData<List<Movement>> getMovementOfWallet(Wallet wallet);
}

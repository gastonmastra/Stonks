package com.example.stonks.database.repository.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.room.entities.Wallet;

import java.util.List;

public interface IMovementRepository {
    MutableLiveData<List<Movement>> getAllMovements();
    Movement getMovement(int movementId);
    void insertMovement(Movement movement);
    void updateMovement(Movement movement);
    void deleteMovement(Movement movement);

    void getMovementOfWallet(Wallet wallet);
}

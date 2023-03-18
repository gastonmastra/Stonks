package com.example.stonks.services.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.entities.Movement;
import com.example.stonks.entities.Wallet;

import java.util.List;

public interface IMovementsService {
    Movement getMovement(int id);
    MutableLiveData<List<Movement>> getMovements();
    void insertMovement(Movement movement);
    void updateMovement(Movement movement);
    void deleteMovement(Movement movement);
    MutableLiveData<List<Movement>> getMovementsOfWallet(Wallet wallet);
}

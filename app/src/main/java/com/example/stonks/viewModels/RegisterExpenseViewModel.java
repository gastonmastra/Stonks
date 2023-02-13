package com.example.stonks.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.stonks.database.AppDatabase;
import com.example.stonks.database.daos.entities.Classification;
import com.example.stonks.database.daos.entities.Movement;
import com.example.stonks.database.daos.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.database.repository.room.MovementRepositoryRoom;

import java.util.Date;

public class RegisterExpenseViewModel extends AndroidViewModel {
    String Description;
    boolean IsDebt;
    double Amount;
    Wallet Wallet;
    Date Date;
    String[] Classifications = new String[]{
            "Comida",
            "Salida",
            "Auto",
            "Ropa"
    };
    Classification Classification;
    IMovementRepository _movementRepository;
    AppDatabase db;

    public RegisterExpenseViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        _movementRepository = MovementRepositoryRoom.getInstance(db.movementDao());
    }


    public Movement Register(String description, double amount){
        Description = description;
        Amount = amount;
        validateInfo();
        Movement movement = Wallet.createMovement(Description, Amount);
        _movementRepository.insertMovement(movement);
        return movement;
    }


    private void validateInfo(){
    }


}

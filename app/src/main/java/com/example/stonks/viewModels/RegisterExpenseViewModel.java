package com.example.stonks.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.AppDatabase;
import com.example.stonks.database.entities.Classification;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.entities.Wallet;
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
    private MutableLiveData<Movement> Movement;


    public RegisterExpenseViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application);
        _movementRepository = MovementRepositoryRoom.getInstance(db.movementDao());
    }

    public MutableLiveData<Movement> getMovement(){
        if (Movement == null){
            Movement = new MutableLiveData<>();
        }
        return Movement;
    }

    public void Register(String description, double amount){
        Description = description;
        Amount = amount;
        validateInfo();
        Wallet = new Wallet();
        Movement movement = Wallet.createMovement(Description, Amount);
        Movement.postValue(movement);
        _movementRepository.insertMovement(movement);
    }


    private void validateInfo(){
    }


}

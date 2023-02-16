package com.example.stonks.viewModels;

import android.app.Application;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.AppDatabase;
import com.example.stonks.database.entities.Classification;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IClassificationRepository;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.example.stonks.database.repository.room.ClassificationRepositoryRoom;
import com.example.stonks.database.repository.room.MovementRepositoryRoom;
import com.example.stonks.database.repository.room.WalletRepositoryRoom;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegisterExpenseViewModel extends AndroidViewModel {
    String Description;
    boolean IsDebt;
    double Amount;
    Wallet Wallet;
    Date Date;
    Classification Classification;
    IMovementRepository _movementRepository;
    IClassificationRepository _classificationRepository;
    IWalletRepository _walletRepository;
    AppDatabase db;
    private MutableLiveData<Movement> Movement;
    private MutableLiveData<List<Classification>> Classifications;


    public RegisterExpenseViewModel(@NonNull Application application) {
        super(application);
        db = AppDatabase.getInstance(application.getApplicationContext());
        _movementRepository = MovementRepositoryRoom.getInstance(db.movementDao());
        _walletRepository = WalletRepositoryRoom.getInstance(db.walletDao());
        _classificationRepository = ClassificationRepositoryRoom.getInstance(db.classificationDao());
    }

    public MutableLiveData<Movement> getMovement(){
        if (Movement == null){
            Movement = new MutableLiveData<>();
        }
        return Movement;
    }

    public List<Classification> getClassifications(){
        return _classificationRepository.getAllClassifications();
    }

    public List<Wallet> getWallets(){
        return _walletRepository.getAllWallets();
    }

    public void Register(String description, double amount, long classification, long wallet){
        Description = description;
        Amount = amount;
        validateInfo();
        Wallet = _walletRepository.getWallet(wallet);
        Movement movement = Wallet.createMovement(Description, Amount, classification, wallet);
        _walletRepository.updateWallet(Wallet);
        Movement.postValue(movement);
        _movementRepository.insertMovement(movement);
    }


    private void validateInfo(){
    }


}

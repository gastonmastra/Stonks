package com.example.stonks.viewModels;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.Firebase;
import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.database.repository.firebase.ClassificationRepositoryFirebase;
import com.example.stonks.database.repository.firebase.MovementRepositoryFirebase;
import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.database.repository.interfaces.IClassificationRepository;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class RegisterExpenseViewModel extends AndroidViewModel {
    String Description;
    double Amount;
    Wallet Wallet;
    IMovementRepository _movementRepository;
    IClassificationRepository _classificationRepository;
    IWalletRepository _walletRepository;
    private MutableLiveData<List<Classification>> classifications;
    private MutableLiveData<List<Wallet>> wallets;


    public RegisterExpenseViewModel(@NonNull Application application) {
        super(application);
        _movementRepository = MovementRepositoryFirebase.getInstance();
        _walletRepository = WalletRepositoryFirebase.getInstance();
        _classificationRepository = ClassificationRepositoryFirebase.getInstance();
        listenToClassifications();
        listenToWallets();
    }

    private void listenToClassifications() {
        FirebaseFirestore db = Firebase.getInstance();
        db.collection("classifications").addSnapshotListener((value, error) -> {
           if (error != null){
               Log.w(TAG, "Listen failed", error);
           }
           if (value != null){
               classifications.setValue(value.toObjects(Classification.class));
           }
        });
    }
    private void listenToWallets() {
        FirebaseFirestore db = Firebase.getInstance();
        db.collection("wallets").addSnapshotListener((value, error) -> {
           if (error != null){
               Log.w(TAG, "Listen failed", error);
           }
           if (value != null){
               wallets.setValue(value.toObjects(Wallet.class));
           }
        });
    }

    public MutableLiveData<List<Classification>> getClassifications(){
        if (classifications == null){
            classifications = new MutableLiveData<>();
        }
        return classifications;
    }

    public MutableLiveData<List<Wallet>> getWallets(){
        if (wallets == null){
            wallets = new MutableLiveData<>();
        }
        return wallets;
    }

    public void register(String description, double amount, long classification, long wallet){
        Description = description;
        Amount = amount;
        Wallet = _walletRepository.getWallet(wallet);
        Movement movement = Wallet.createMovement(Description, Amount, classification, wallet);
        _walletRepository.updateWallet(Wallet);
        _movementRepository.insertMovement(movement);
    }

}

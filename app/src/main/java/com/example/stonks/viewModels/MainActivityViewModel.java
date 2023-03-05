package com.example.stonks.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.firebase.MovementRepositoryFirebase;
import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.example.stonks.database.repository.room.entities.Wallet;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    MutableLiveData<List<Wallet>> wallets;
    IWalletRepository walletRepository;
    IMovementRepository movementRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        walletRepository = WalletRepositoryFirebase.getInstance();
        movementRepository = MovementRepositoryFirebase.getInstance();
        wallets = walletRepository.getAllWallets();
    }

    public MutableLiveData<List<Wallet>> getWallets(){
        return wallets;
    }

}

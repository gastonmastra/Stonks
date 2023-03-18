package com.example.stonks.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.firebase.MovementRepositoryFirebase;
import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.entities.Movement;
import com.example.stonks.entities.Wallet;
import com.example.stonks.services.MovementsService;
import com.example.stonks.services.WalletService;
import com.example.stonks.services.interfaces.IMovementsService;
import com.example.stonks.services.interfaces.IWalletService;

import java.util.ArrayList;
import java.util.List;

public class ViewMovementsViewModel extends AndroidViewModel {

    MutableLiveData<List<Movement>> movements;
    List<Movement> allMovements = new ArrayList<>();
    MutableLiveData<List<Wallet>> wallets;
    IMovementsService movementsService;
    IWalletService walletsService;
    public ViewMovementsViewModel(@NonNull Application application) {
        super(application);

        movementsService = new MovementsService(MovementRepositoryFirebase.getInstance());
        walletsService = new WalletService(WalletRepositoryFirebase.getInstance());
        listenToMovements();
        listenToWallets();
    }

    private void listenToMovements() {
        movements = movementsService.getMovements();
    }

    private void listenToWallets() {
        wallets = walletsService.getWallets();
    }

    public MutableLiveData<List<Movement>> getMovements(){
        if (movements == null){
            movements = new MutableLiveData<>();
        }
        return movements;
    }


    public LiveData<List<Wallet>> getWallets() {
        if(wallets == null)
            wallets = new MutableLiveData<>();
        return wallets;
    }

    public MutableLiveData<List<Movement>> filterByWallet(Wallet wallet) {
        return this.movementsService.getMovementsOfWallet(wallet);
    }
}

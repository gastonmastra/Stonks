package com.example.stonks.viewModels;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.database.repository.room.AppDatabase;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.example.stonks.database.repository.room.WalletRepositoryRoom;

public class RegisterWalletViewModel extends AndroidViewModel {
    IWalletRepository walletRepository;

    public RegisterWalletViewModel(@NonNull Application application) {
        super(application);
        walletRepository = new WalletRepositoryFirebase();
    }

    public void register(String name, long amount){
        String txtResult;
        if (validateInfo(name)){
            Wallet newWallet = new Wallet();
            newWallet.setName(name);
            newWallet.setMoney(amount);
            walletRepository.insertWallet(newWallet);
            txtResult = "Se insertó correctamente la billetera " + name;
        }
        else {
            txtResult = "No se puede registrar una billetera sin nombre.";
        }
        Toast.makeText(getApplication(), txtResult, Toast.LENGTH_SHORT).show();
    }

    private boolean validateInfo(String name) {
        return !name.isEmpty();
    }
}

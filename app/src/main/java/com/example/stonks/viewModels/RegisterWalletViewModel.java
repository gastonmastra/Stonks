package com.example.stonks.viewModels;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;

public class RegisterWalletViewModel extends AndroidViewModel {
    IWalletRepository walletRepository;

    public RegisterWalletViewModel(@NonNull Application application) {
        super(application);
        walletRepository = new WalletRepositoryFirebase();
    }

    public void register(String name, long amount){
        if (validateInfo(name)){
            Wallet newWallet = new Wallet();
            newWallet.setName(name);
            newWallet.setMoney(amount);
            walletRepository.insertWallet(newWallet, this::showResult);
        }
        else {
            Toast.makeText(getApplication(),
                    "No se puede registrar una billetera sin nombre",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private void showResult(String s) {
        Toast.makeText(getApplication(), s, Toast.LENGTH_SHORT).show();
    }

    private boolean validateInfo(String name) {
        return !name.isEmpty();
    }
}

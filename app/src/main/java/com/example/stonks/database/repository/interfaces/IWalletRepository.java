package com.example.stonks.database.repository.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.database.repository.room.entities.Wallet;

import java.util.List;

public interface IWalletRepository {
    MutableLiveData<List<Wallet>> getAllWallets();

    void getWallet(String name, WalletRepositoryFirebase.FirebaseCallback callback);

    void insertWallet(Wallet wallet);
    void updateWallet(Wallet wallet);
    void deleteWallet(Wallet wallet);
}

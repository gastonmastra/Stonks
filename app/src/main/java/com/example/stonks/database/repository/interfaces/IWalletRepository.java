package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.repository.firebase.WalletRepositoryFirebase;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.google.android.gms.tasks.Task;

import java.util.List;

public interface IWalletRepository {
    List<Wallet> getAllWallets();

    void getWallet(String name, WalletRepositoryFirebase.FirebaseCallback callback);

    void insertWallet(Wallet wallet);
    void updateWallet(Wallet wallet);
    void deleteWallet(Wallet wallet);
}

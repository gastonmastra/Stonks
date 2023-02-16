package com.example.stonks.database.repository.firebase;

import com.example.stonks.database.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;

import java.util.List;

public class WalletRepositoryFirebase implements IWalletRepository {
    private static WalletRepositoryFirebase instance;

    public static WalletRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new WalletRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public List<Wallet> getAllWallets() {
        return null;
    }

    @Override
    public Wallet getWallet(long walletId) {
        return null;
    }

    @Override
    public void insertWallet(Wallet wallet) {

    }

    @Override
    public void updateWallet(Wallet wallet) {

    }

    @Override
    public void deleteWallet(Wallet wallet) {

    }
}

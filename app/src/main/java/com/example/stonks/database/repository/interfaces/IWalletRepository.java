package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.entities.Wallet;

import java.util.List;

public interface IWalletRepository {
    List<Wallet> getAllWallets();
    Wallet getWallet(long walletId);
    void insertWallet(Wallet wallet);
    void updateWallet(Wallet wallet);
    void deleteWallet(Wallet wallet);
}

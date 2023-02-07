package com.example.stonks.database.repository.room;

import com.example.stonks.database.daos.WalletDao;
import com.example.stonks.database.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;

import java.util.List;

public class WalletRepositoryRoom implements IWalletRepository {
    WalletDao dao;

    public WalletRepositoryRoom(WalletDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Wallet> getAllWallets() {
        return dao.getWallets();
    }

    @Override
    public Wallet getWallet(int walletId) {
        return dao.getWallet(walletId);
    }

    @Override
    public void insertWallet(Wallet wallet) {
        dao.insertWallet(wallet);
    }

    @Override
    public void updateWallet(Wallet wallet) {
        dao.updateWallet(wallet);
    }

    @Override
    public void deleteWallet(Wallet wallet) {
        dao.deleteWallet(wallet);
    }
}

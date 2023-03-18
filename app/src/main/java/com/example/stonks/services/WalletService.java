package com.example.stonks.services;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.example.stonks.entities.Wallet;
import com.example.stonks.services.interfaces.IWalletService;

import java.util.List;

public class WalletService implements IWalletService {
    IWalletRepository repository;
    public WalletService(IWalletRepository repository) {
        this.repository = repository;
    }

    @Override
    public MutableLiveData<List<Wallet>> getWallets() {
        return repository.getAllWallets();
    }
}

package com.example.stonks.services.interfaces;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.room.entities.Wallet;

import java.util.List;

public interface IWalletService {
    MutableLiveData<List<Wallet>> getWallets();
}

package com.example.stonks.database.daos;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.stonks.database.entities.Wallet;

import java.util.List;

@Dao
public interface WalletDao {

    @Query("SELECT * FROM Wallets")
    List<Wallet> getWallets();
}

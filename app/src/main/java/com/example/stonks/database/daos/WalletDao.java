package com.example.stonks.database.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.entities.Wallet;

import java.util.List;

@Dao
public interface WalletDao {

    @Query("SELECT * FROM Wallets")
    List<Wallet> getWallets();
    @Query("SELECT * FROM Wallets WHERE wallet_id = :walletId")
    Wallet getWallet(long walletId);
    @Insert
    void insertWallet(Wallet wallet);
    @Update
    void updateWallet(Wallet wallet);
    @Delete
    void deleteWallet(Wallet wallet);
}

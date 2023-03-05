package com.example.stonks.database.repository.firebase;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.Firebase;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class WalletRepositoryFirebase implements IWalletRepository {
    private final CollectionReference walletCollection = FirebaseFirestore.getInstance()
            .collection("wallets");
    private static WalletRepositoryFirebase instance;

    public static WalletRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new WalletRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public MutableLiveData<List<Wallet>> getAllWallets() {
        MutableLiveData<List<Wallet>> wallets = new MutableLiveData<>();
        walletCollection.addSnapshotListener((value, error) -> {
            if (error != null)
                Log.w(TAG, "Listed failed", error);
            if (value != null)
                wallets.setValue(value.toObjects(Wallet.class));
        });
        return wallets;
    }

    @Override
    public void getWallet(String name, FirebaseCallback callback) {
        walletCollection.document(name).get()
                .addOnSuccessListener(documentSnapshot ->
                        callback.getWallet(documentSnapshot.toObject(Wallet.class))
                );
    }

    public interface FirebaseCallback{
        void getWallet(Wallet wallet);
    }

    @Override
    public void insertWallet(Wallet wallet, Firebase.IFirebaseCallback callback) {
        walletCollection.document(wallet.getName())
                .get()
                .addOnSuccessListener(documentSnapshot -> {
                        if (documentSnapshot.exists()){
                            callback.onCallback(
                                    "The wallet " + wallet.getName() + " already exists!"
                            );
                        } else{
                            walletCollection.document(wallet.getName()).set(wallet);
                            callback.onCallback(
                                    "Wallet " + wallet.getName() + " registered successfully"
                            );
                        }
                    });

    }

    @Override
    public void updateWallet(Wallet wallet) {
        walletCollection.document(wallet.getName()).set(wallet);
    }

    @Override
    public void deleteWallet(Wallet wallet) {
        walletCollection.document(wallet.getName()).delete();
    }
}

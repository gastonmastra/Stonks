package com.example.stonks.database.repository.firebase;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
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
    public List<Wallet> getAllWallets() {
        List<Wallet> wallets = new ArrayList<>();
        walletCollection.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documento : task.getResult()){
                                wallets.add(documento.toObject(Wallet.class));
                            }
                        }
                        else{
                            Log.d(TAG, "Error al obtener los datos, error: " + task.getException());
                        }
                    }
                });
        return wallets;
    }

    @Override
    public void getWallet(String name, FirebaseCallback callback) {
        Wallet wallet = new Wallet();
        walletCollection.document(name).get()
                .addOnSuccessListener(documentSnapshot -> {
                    callback.getWallet(documentSnapshot.toObject(Wallet.class));
                });
    }

    public interface FirebaseCallback{
        void getWallet(Wallet wallet);
    }

    @Override
    public void insertWallet(Wallet wallet) {
        walletCollection.document(wallet.getName()).set(wallet);
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

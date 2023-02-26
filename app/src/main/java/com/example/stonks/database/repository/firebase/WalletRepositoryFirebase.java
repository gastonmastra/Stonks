package com.example.stonks.database.repository.firebase;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.stonks.database.Firebase;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.database.repository.interfaces.IWalletRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;

import java.util.ArrayList;
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
        List<Wallet> wallets = new ArrayList<>();
        Firebase.getInstance().collection("wallets")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot documento : task.getResult()){
                                wallets.add(documento.toObject(Wallet.class));
                                Object data = documento.getData();
                                Object object = documento.toObject(Wallet.class);
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
    public Wallet getWallet(long walletId) {
        Wallet wallet = new Wallet();
        FirebaseFirestore.getInstance().collection("wallets")
                .whereEqualTo("id",walletId).get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        wallet.setWalletId(queryDocumentSnapshots.toObjects(Wallet.class).get(0)
                                .getWalletId());
                        wallet.setName(queryDocumentSnapshots.toObjects(Wallet.class).get(0)
                                .getName());
                    }
                });
        return wallet;
    }

    @Override
    public void insertWallet(Wallet wallet) {
        FirebaseFirestore.getInstance().collection("wallets").document(wallet.getName())
                .set(wallet);
    }

    @Override
    public void updateWallet(Wallet wallet) {

    }

    @Override
    public void deleteWallet(Wallet wallet) {

    }
}

package com.example.stonks.database;

import com.google.firebase.firestore.FirebaseFirestore;

public class Firebase {
    private static FirebaseFirestore instance;
    private Firebase() { }
    public static FirebaseFirestore getInstance(){
        if (instance == null){
            instance = FirebaseFirestore.getInstance();
        }
        return instance;
    }

    public interface IFirebaseCallback {
        void onCallback(String result);
    }
}

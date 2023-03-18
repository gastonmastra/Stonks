package com.example.stonks.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.stonks.database.Firebase;
import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends AndroidViewModel {

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void login(String usernameEmail, String password, Firebase.IFirebaseCallback callback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(usernameEmail, password).addOnCompleteListener(task -> {
           if (task.isSuccessful())
               callback.onCallback("");
           else
               callback.onCallback("Username o password incorrectos");
        });
    }

    public void signUp(String usernameEmail, String password, Firebase.IFirebaseCallback callback) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(usernameEmail, password).addOnCompleteListener(task -> {
            if (task.isSuccessful())
                callback.onCallback("");
            else
                callback.onCallback("Usuario ya registrado");
        });
    }
}

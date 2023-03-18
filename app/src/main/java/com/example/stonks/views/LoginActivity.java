package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stonks.R;
import com.example.stonks.viewModels.LoginViewModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText etUser, etPassword;
    Button btnSignUp, btnLogin;
    LoginViewModel model;

    String user, password;

    FirebaseUser currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        BindComponents();
        currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null)
            this.goHome();
    }

    private void BindComponents() {
        etUser = findViewById(R.id.user);
        etPassword = findViewById(R.id.password);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(this::SignUp);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this::Login);
        model = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    private void SignUp(View view) {
        if (validateData()){
            model.signUp(user, password, this::onComplete);
        }
    }

    private void onComplete(String error) {
        if (error.isEmpty()){
            this.goHome();
        }
        else
            showError(error);
    }

    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    private void Login(View view) {
        if (validateData()){
            model.login(user, password, this::onComplete);
        }
    }

    private boolean validateData() {
        user = etUser.getText().toString().trim();
        password = etPassword.getText().toString().trim();

        if (password.isEmpty() || user.isEmpty()){
            Toast.makeText(this, "Ingresar datos", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}
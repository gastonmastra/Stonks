package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;

import com.example.stonks.R;
import com.example.stonks.viewModels.RegisterWalletViewModel;

public class RegisterWallet extends AppCompatActivity implements View.OnClickListener{

    RegisterWalletViewModel model;
    EditText name, initialAmount;
    Button btnRegisterWallet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_wallet);
        model = new ViewModelProvider(this).get(RegisterWalletViewModel.class);
        InitializeButtons();

    }

    private void InitializeButtons() {
        name = findViewById(R.id.etName);
        initialAmount = findViewById(R.id.etInitialAmount);
        btnRegisterWallet = findViewById(R.id.btnRegisterWallet);
        btnRegisterWallet.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        String txtName = name.getText().toString();
        long amount;
        if (!initialAmount.getText().toString().equals(""))
            amount = Long.parseLong(initialAmount.getText().toString());
        else
            amount = 0;
        model.register(txtName, amount);
    }


}
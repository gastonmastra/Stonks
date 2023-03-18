package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.stonks.R;
import com.example.stonks.entities.Classification;
import com.example.stonks.entities.Wallet;
import com.example.stonks.viewModels.RegisterExpenseViewModel;

import java.util.List;

public class RegisterExpense extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText etDescription, etMount;
    Spinner spinnerClassification, spinnerWallet;
    String classification;
    Button btnRegister;
    RegisterExpenseViewModel Model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_expense);
        InitializeComponents();
    }

    private void InitializeComponents() {
        spinnerClassification = findViewById(R.id.spinClasification);
        spinnerWallet = findViewById(R.id.spinWallets);
        etDescription = findViewById(R.id.etDescription);
        etMount = findViewById(R.id.etMount);
        btnRegister = findViewById(R.id.btnRegisterExpense);
        btnRegister.setOnClickListener(this::Register);
        Model = new ViewModelProvider(this).get(RegisterExpenseViewModel.class);
        SubscribeData();
    }

    private void SubscribeData() {
        final Observer<List<Classification>> classifications = this::showClassifications;
        Model.getClassifications().observe(this, classifications);
        final Observer<List<Wallet>> wallets = this::showWallets;
        Model.getWallets().observe(this, wallets);
    }

    public void showClassifications(List<Classification> classifications){
        ArrayAdapter<Classification> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classifications);
        spinnerClassification.setAdapter(adapter);
        spinnerClassification.setOnItemSelectedListener(this);
    }

    public void showWallets(List<Wallet> wallets){
        ArrayAdapter<Wallet> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, wallets);
        spinnerWallet.setAdapter(adapter);
        spinnerWallet.setOnItemSelectedListener(this);
    }
    private void Register(View view){
        String description = etDescription.getText().toString();
        double amount = Double.parseDouble(etMount.getText().toString());
        Classification classificationSelected = (Classification)spinnerClassification.getSelectedItem();
        Wallet walletSelected = (Wallet)spinnerWallet.getSelectedItem();
        Model.register(description,
                amount,
                classificationSelected,
                walletSelected);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        classification = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent){

    }
}
package com.example.stonks.views;

import androidx.annotation.Nullable;
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
import android.widget.Toast;

import com.example.stonks.R;
import com.example.stonks.database.entities.Classification;
import com.example.stonks.database.entities.Wallet;
import com.example.stonks.viewModels.RegisterExpenseViewModel;
import com.example.stonks.database.entities.Movement;

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
        spinnerClassification = (Spinner) findViewById(R.id.spinClasification);
        spinnerWallet = (Spinner) findViewById(R.id.spinWallets);
        etDescription = (EditText) findViewById(R.id.etDescription);
        etMount = (EditText) findViewById(R.id.etMount);
        btnRegister = (Button) findViewById(R.id.btnRegisterExpense);
        btnRegister.setOnClickListener(this::Register);
        Model = new ViewModelProvider(this).get(RegisterExpenseViewModel.class);
        SubscribeData();
    }

    private void SubscribeData() {
        final Observer<Movement> movement = new Observer<Movement>() {
            @Override
            public void onChanged(@Nullable final Movement movement) {
                if (movement != null)
                    showMovement(movement);
            }
        };
        Model.getMovement().observe(this, movement);
        final Observer<List<Classification>> classifications = new Observer<List<Classification>>() {
            @Override
            public void onChanged(List<Classification> classifications) {
                showClassifications(classifications);
            }
        };
        showClassifications(Model.getClassifications());
        final Observer<List<Wallet>> wallets = new Observer<List<Wallet>>() {
            @Override
            public void onChanged(List<Wallet> wallets) {
                showWallets(wallets);
            }
        };
        showWallets(Model.getWallets());
    }

    public void showClassifications(List<Classification> classifications){
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, classifications);
        spinnerClassification.setAdapter(adapter);
        spinnerClassification.setOnItemSelectedListener(this);
    }

    public void showWallets(List<Wallet> wallets){
        ArrayAdapter adapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, wallets);
        spinnerWallet.setAdapter(adapter);
        spinnerWallet.setOnItemSelectedListener(this);
    }

    private void showMovement(Movement movement){
        Toast.makeText(this, "Movimiento " + movement.getDescription() + " a $" + movement.getAmount() + " creado con éxito.", Toast.LENGTH_LONG).show();
    }

    private void Register(View view){
        String description = etDescription.getText().toString();
        double amount = Double.parseDouble(etMount.getText().toString());
        Classification classificationSelected = (Classification)spinnerClassification.getSelectedItem();
        Wallet walletSelected = (Wallet)spinnerWallet.getSelectedItem();
        Model.Register(description,
                amount,
                classificationSelected.getClassificationId(),
                walletSelected.getWalletId());
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        classification = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent){

    }
}
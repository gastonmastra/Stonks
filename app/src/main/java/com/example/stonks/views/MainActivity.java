package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stonks.R;
import com.example.stonks.entities.Wallet;
import com.example.stonks.utilities.AdapterWallets;
import com.example.stonks.viewModels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRegisterExpense, btnRegisterWallet, btnViewMovements;
    MainActivityViewModel model;
    RecyclerView recycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BindData();
        SubscribeData();
    }

    private void SubscribeData() {
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);
        final Observer<List<Wallet>> wallets = this::showWallets;
        model.getWallets().observe(this, wallets);
    }

    private void showWallets(List<Wallet> wallets) {
        AdapterWallets adapter = new AdapterWallets(wallets);
        recycler.setAdapter(adapter);
    }

    private void BindData(){
        btnRegisterExpense = findViewById(R.id.btnRegisterExpense);
        btnRegisterExpense.setOnClickListener(this);
        btnRegisterWallet = findViewById(R.id.btnRegisterWallet);
        btnRegisterWallet.setOnClickListener(this);
        btnViewMovements = findViewById(R.id.btnViewMovements);
        btnViewMovements.setOnClickListener(this);
        recycler = findViewById(R.id.recyclerId);
        recycler.setLayoutManager(
                new LinearLayoutManager(this,
                        LinearLayoutManager.HORIZONTAL,
                        false));
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btnRegisterExpense) {
            Intent intent = new Intent(this, RegisterExpense.class);
            startActivity(intent);
        }else if(view.getId() == R.id.btnRegisterWallet){
            Intent intent = new Intent(this, RegisterWallet.class);
            startActivity(intent);
        }else if(view.getId() == R.id.btnViewMovements){
            Intent intent = new Intent(this, ViewMovements.class);
            startActivity(intent);
        }
    }
}
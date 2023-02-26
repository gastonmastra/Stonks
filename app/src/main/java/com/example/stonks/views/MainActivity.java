package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.stonks.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnRegisterExpense, btnRegisterWallet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitializeButtons();
    }

    private void InitializeButtons(){
        btnRegisterExpense = (Button) findViewById(R.id.btnRegisterExpense);
        btnRegisterExpense.setOnClickListener(this);
        btnRegisterWallet = (Button) findViewById(R.id.btnRegisterWallet);
        btnRegisterWallet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btnRegisterExpense) {
            Intent intent = new Intent(this, RegisterExpense.class);
            startActivity(intent);
        }else if(view.getId() == R.id.btnRegisterWallet){
            Intent intent = new Intent(this, RegisterWallet.class);
            startActivity(intent);
        }
    }
}
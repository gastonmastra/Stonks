package com.example.stonks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitializeButtons();
    }

    private void InitializeButtons(){
        findViewById(R.id.btnRegisterExpense).setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view.getId() == R.id.btnRegisterExpense) {
            Intent intent = new Intent(this, RegisterExpense.class);
            startActivity(intent);
        }
    }
}
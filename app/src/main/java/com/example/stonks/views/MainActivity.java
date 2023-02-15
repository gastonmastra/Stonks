package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.stonks.R;
import com.example.stonks.database.entities.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvUsers;

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
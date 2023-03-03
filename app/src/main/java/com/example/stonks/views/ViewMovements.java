package com.example.stonks.views;

import static java.util.logging.Logger.global;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.stonks.R;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.room.entities.Wallet;
import com.example.stonks.utilities.CustomAdapter;
import com.example.stonks.viewModels.RegisterExpenseViewModel;
import com.example.stonks.viewModels.ViewMovementsViewModel;

import java.util.List;

public class ViewMovements extends AppCompatActivity {

    ListView lvMovements;
    Spinner spinnerWallets;
    ViewMovementsViewModel model;
    List<Movement> movements;
    private boolean spinnerInitialized = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movements);
        InitializeComponents();
        lvMovements = findViewById(R.id.lvMovements);
        model = new ViewModelProvider(this).get(ViewMovementsViewModel.class);
        SubscribeData();
    }

    private void InitializeComponents() {
        spinnerWallets = findViewById(R.id.spinWallets);
    }

    private void SubscribeData() {
        final Observer<List<Movement>> movements = this::showMovements;
        model.getMovements().observe(this, movements);
        final Observer<List<Wallet>> wallets = this::showWallets;
        model.getWallets().observe(this, wallets);
    }

    private void showMovements(List<Movement> movements) {
        this.movements = movements;
        CustomAdapter adapter = new CustomAdapter(this, this.movements);
        lvMovements.setAdapter(adapter);
    }

    private void showWallets(List<Wallet> wallets){
        ArrayAdapter adapter = new ArrayAdapter(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                wallets);
        spinnerWallets.setAdapter(adapter);
        spinnerWallets.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinnerInitialized)
                    model.filterByWallet((Wallet)adapterView.getItemAtPosition(i));
                spinnerInitialized = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
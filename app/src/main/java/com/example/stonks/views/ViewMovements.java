package com.example.stonks.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;

import com.example.stonks.R;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.utilities.CustomAdapter;
import com.example.stonks.viewModels.RegisterExpenseViewModel;
import com.example.stonks.viewModels.ViewMovementsViewModel;

import java.util.List;

public class ViewMovements extends AppCompatActivity {

    ListView lvMovements;
    ViewMovementsViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_movements);
        lvMovements = findViewById(R.id.lvMovements);
        model = new ViewModelProvider(this).get(ViewMovementsViewModel.class);
        SubscribeData();
    }

    private void SubscribeData() {
        final Observer<List<Movement>> movements = this::showMovements;
        model.getMovements().observe(this, movements);

    }

    private void showMovements(List<Movement> movements) {
        CustomAdapter adapter = new CustomAdapter(this, movements);
        lvMovements.setAdapter(adapter);
    }
}
package com.example.stonks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterExpense extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] Clasifications = new String[]{
            "Comida",
            "Salida",
            "Auto",
            "Ropa"
    };
    EditText etDescription, etMount;
    Spinner spinnerClasification;
    String clasification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_expense);

        spinnerClasification = (Spinner) findViewById(R.id.spinClasification);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.clasifications, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClasification.setAdapter(adapter);
        spinnerClasification.setOnItemSelectedListener(this);

        etDescription = (EditText) findViewById(R.id.etDescription);
        etMount = (EditText) findViewById(R.id.etMount);

        findViewById(R.id.btnRegisterExpense).setOnClickListener(this::RegisterExpensee);
    }

    private void RegisterExpensee(View view){
        String description = etDescription.getText().toString();
        double mount = Double.parseDouble(etMount.getText().toString());
        Movement movement = new OutputMovement(description, false, mount);
        Toast.makeText(this, "Se registró " + movement.Description + " a $" + movement.Mount, Toast.LENGTH_LONG).show();
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        clasification = parent.getItemAtPosition(pos).toString();
    }

    public void onNothingSelected(AdapterView<?> parent){

    }
}
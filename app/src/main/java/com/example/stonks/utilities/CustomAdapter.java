package com.example.stonks.utilities;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.stonks.R;
import com.example.stonks.database.repository.room.entities.Movement;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Movement> movements;

    public CustomAdapter(Context context, List<Movement> movements) {
        this.context = context;
        this.movements = movements;
        movements.sort(Comparator.comparing(Movement::getDate).reversed());
    }

    @Override
    public int getCount() {
        return movements.size();
    }

    @Override
    public Object getItem(int i) {
        return movements.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView txtMovement;
        TextView txtWallet;
        TextView txtAmount;
        TextView txtAmountWallet;
        TextView txtDate;
        TextView txtHour;

        Movement movement = movements.get(i);

        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_movements, null);

        txtMovement = view.findViewById(R.id.txtMovement);
        txtWallet = view.findViewById(R.id.txtWallet);
        txtAmount = view.findViewById(R.id.txtAmount);
        txtAmountWallet = view.findViewById(R.id.txtAmountWallet);
        txtDate = view.findViewById(R.id.txtDate);
        txtHour = view.findViewById(R.id.txtHour);

        txtMovement.setText(movement.getDescription());
        txtWallet.setText(movement.getWallet().getName());
        txtAmount.setText(
                String.format(Locale.getDefault(), "$%.2f", movement.getAmount())
        );
        txtAmountWallet.setText(
                String.format(Locale.getDefault(), "$%.2f", movement.getBeforeAmount() - movement.getAmount())
        );
        final String patternDate = "dd/MM/yyyy";
        String formattedDate = new SimpleDateFormat(patternDate, Locale.getDefault()).format(movement.getDate());
        txtDate.setText(formattedDate);
        String patternHour = "hh:mm";
        String formattedHour = new SimpleDateFormat(patternHour, Locale.getDefault()).format(movement.getDate());
        txtHour.setText(formattedHour);

        return view;
    }
}

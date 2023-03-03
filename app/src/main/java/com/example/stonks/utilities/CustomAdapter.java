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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    List<Movement> movements;

    public CustomAdapter(Context context, List<Movement> movements) {
        this.context = context;
        this.movements = movements;
        this.movements.sort(Comparator.comparing(Movement::getDate));
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
        txtAmount.setText("$" + Double.toString(movement.getAmount()));
        txtAmountWallet.setText(
                "$" + Double.toString(movement.getBeforeAmount() - movement.getAmount())
        );
        final String patternDate = "dd/MM/yyyy";
        String formatedDate = new SimpleDateFormat(patternDate).format(movement.getDate());
        txtDate.setText(formatedDate);
        String patternHour = "hh:mm";
        String formatedHour = new SimpleDateFormat(patternHour).format(movement.getDate());
        txtHour.setText(formatedHour);

        return view;
    }
}

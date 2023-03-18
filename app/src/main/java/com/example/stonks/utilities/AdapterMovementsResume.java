package com.example.stonks.utilities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;
import com.example.stonks.entities.Movement;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class AdapterMovementsResume extends RecyclerView.Adapter<AdapterMovementsResume.ViewHolderMovementsResume> {
    List<Movement> movements;

    public AdapterMovementsResume(List<Movement> movements) {
        this.movements = movements;
    }

    @NonNull
    @Override
    public AdapterMovementsResume.ViewHolderMovementsResume onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movements_resume, parent, false);
        return new ViewHolderMovementsResume(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovementsResume.ViewHolderMovementsResume holder, int position) {
        movements.sort(Comparator.comparing(Movement::getDate).reversed());
        holder.assignData(movements.get(position));
    }

    @Override
    public int getItemCount() {
        return movements.size();
    }

    public static class ViewHolderMovementsResume extends RecyclerView.ViewHolder {
        TextView movementDescription, movementAmount;
        public ViewHolderMovementsResume(@NonNull View itemView) {
            super(itemView);
            movementDescription = itemView.findViewById(R.id.movementDescription);
            movementAmount = itemView.findViewById(R.id.movementAmount);
        }

        public void assignData(Movement movement) {
            movementDescription.setText(movement.getDescription());
            movementAmount.setText(
                    String.format(Locale.getDefault(), "$%.2f", movement.getAmount())
            );
        }
    }
}

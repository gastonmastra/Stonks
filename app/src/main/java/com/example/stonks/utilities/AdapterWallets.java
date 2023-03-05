package com.example.stonks.utilities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.stonks.R;
import com.example.stonks.database.repository.firebase.MovementRepositoryFirebase;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.room.entities.Wallet;

import java.util.List;
import java.util.Locale;

public class AdapterWallets extends RecyclerView.Adapter<AdapterWallets.ViewHolderWallets>{

    List<Wallet> wallets;

    public AdapterWallets(List<Wallet> wallets) {
        this.wallets = wallets;
    }

    @NonNull
    @Override
    public ViewHolderWallets onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_wallets, parent, false);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT
        );
        params.setMargins(10, 0, 10, 0);
        view.setLayoutParams(params);
        return new ViewHolderWallets(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderWallets holder, int position) {
        Wallet wallet = wallets.get(position);
        holder.assignData(wallet);
    }

    @Override
    public int getItemCount() {
        return wallets.size();
    }

    public static class ViewHolderWallets extends RecyclerView.ViewHolder{
        TextView walletName, walletAmount;
        RecyclerView recycler;


        public ViewHolderWallets(@NonNull View itemView) {
            super(itemView);
            walletName = itemView.findViewById(R.id.walletName);
            walletAmount = itemView.findViewById(R.id.walletAmount);
            recycler = itemView.findViewById(R.id.recyclerId);
        }

        public void assignData(Wallet wallet) {
            walletName.setText(wallet.getName());
            walletAmount.setText(
                    String.format(Locale.getDefault(), "$%.2f", wallet.getMoney())
            );
            recycler.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));
            final Observer<List<Movement>> movements = this::showMovements;
            new MovementRepositoryFirebase().getMovementOfWallet(wallet)
                    .observe( (LifecycleOwner) itemView.getContext(), movements);

        }

        private void showMovements(List<Movement> movements) {
            AdapterMovementsResume adapter = new AdapterMovementsResume(movements);
            recycler.setAdapter(adapter);
        }
    }
}

package com.example.stonks.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.stonks.database.repository.firebase.MovementRepositoryFirebase;
import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.services.MovementsService;
import com.example.stonks.services.interfaces.IMovementsService;
import com.example.stonks.utilities.CustomAdapter;

import java.util.List;

public class ViewMovementsViewModel extends AndroidViewModel {

    MutableLiveData<List<Movement>> movements;
    IMovementsService movementsService;
    public ViewMovementsViewModel(@NonNull Application application) {
        super(application);

        movementsService = new MovementsService(MovementRepositoryFirebase.getInstance());
        listenToMovements();
    }

    private void listenToMovements() {
        movements = movementsService.getMovements();
    }

    public MutableLiveData<List<Movement>> getMovements(){
        if (movements == null){
            movements = new MutableLiveData<>();
        }
        return movements;
    }


}

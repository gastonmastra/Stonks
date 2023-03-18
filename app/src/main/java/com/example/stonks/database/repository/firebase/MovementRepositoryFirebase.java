package com.example.stonks.database.repository.firebase;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.entities.Movement;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.example.stonks.entities.Wallet;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;

public class MovementRepositoryFirebase implements IMovementRepository {
    private final CollectionReference movementsCollection = FirebaseFirestore.getInstance()
            .collection("movements");
    private final MutableLiveData<List<Movement>> movements = new MutableLiveData<>();
    private static MovementRepositoryFirebase instance;
    public static MovementRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new MovementRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public MutableLiveData<List<Movement>> getAllMovements() {
        movementsCollection.addSnapshotListener(((value, error) -> {
            if (error != null)
                Log.w(TAG, "Listed failed", error);
            if (value != null)
                movements.setValue(value.toObjects(Movement.class));
        }));
        return movements;
    }

    @Override
    public Movement getMovement(int movementId) {
        movementsCollection.document(Long.toString(movementId)).get()
                .addOnSuccessListener(documentSnapshot -> {
                });
        return null;
    }

    @Override
    public void insertMovement(Movement movement) {
        movementsCollection.add(movement)
                .addOnSuccessListener(documentReference -> {
                    String id = documentReference.getId();
                    movementsCollection.document(id).update("entryId", id);
                });
    }

    @Override
    public void updateMovement(Movement movement) {
        movementsCollection.document(movement.getEntryId()).set(movement);
    }

    @Override
    public void deleteMovement(Movement movement) {
        movementsCollection.document(movement.getEntryId()).delete();
    }

    @Override
    public MutableLiveData<List<Movement>> getMovementOfWallet(Wallet wallet) {
        movementsCollection.
                whereEqualTo("wallet.name", wallet.getName())
                .addSnapshotListener( ((value, error) -> {
                    if (error != null){
                        Log.w(TAG, "Listed failed", error);
                    }
                    if (value != null){
                        movements.setValue(value.toObjects(Movement.class));
                    }
                }));
        return movements;
    }
}

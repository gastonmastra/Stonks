package com.example.stonks.database.repository.firebase;

import androidx.annotation.NonNull;

import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.interfaces.IMovementRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MovementRepositoryFirebase implements IMovementRepository {
    private final CollectionReference movementsCollection = FirebaseFirestore.getInstance()
            .collection("movements");
    private static MovementRepositoryFirebase instance;
    public static MovementRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new MovementRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public List<Movement> getAllMovements() {
        List<Movement> movements = new ArrayList<>();
        movementsCollection.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        for (QueryDocumentSnapshot document: queryDocumentSnapshots){
                            movements.add(document.toObject(Movement.class));
                        }
                    }
                });
        return movements;
    }

    @Override
    public Movement getMovement(int movementId) {
        movementsCollection.document(Long.toString(movementId)).get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                    }
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
}

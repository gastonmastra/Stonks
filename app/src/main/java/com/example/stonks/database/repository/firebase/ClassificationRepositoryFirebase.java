package com.example.stonks.database.repository.firebase;

import androidx.annotation.NonNull;

import com.example.stonks.database.Firebase;
import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.interfaces.IClassificationRepository;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ClassificationRepositoryFirebase implements IClassificationRepository {

    private static ClassificationRepositoryFirebase instance;
    private ClassificationRepositoryFirebase(){}
    public static ClassificationRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new ClassificationRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public List<Classification> getAllClassifications() {
        List<Classification> classifications = new ArrayList<>();
        Firebase.getInstance().collection("classifications").get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()){
                            for (QueryDocumentSnapshot document : task.getResult()){
                                classifications.add(document.toObject(Classification.class));
                            }
                        }
                    }
                });
        return classifications;
    }

    @Override
    public Classification getClassification(String name) {
        return null;
    }

    @Override
    public void insertClassification(Classification classification) {

    }

    @Override
    public void deleteClassification(Classification classification) {

    }

    @Override
    public void updateClassification(Classification classification) {

    }
}

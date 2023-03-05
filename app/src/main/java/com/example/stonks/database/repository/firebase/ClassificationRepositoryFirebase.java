package com.example.stonks.database.repository.firebase;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.interfaces.IClassificationRepository;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ClassificationRepositoryFirebase implements IClassificationRepository {

    private static ClassificationRepositoryFirebase instance;
    MutableLiveData<List<Classification>> classifications;
    private final CollectionReference classificationCollection = FirebaseFirestore.getInstance()
            .collection("classifications");
    private ClassificationRepositoryFirebase(){}
    public static ClassificationRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new ClassificationRepositoryFirebase();
        }
        return instance;
    }
    @Override
    public MutableLiveData<List<Classification>> getAllClassifications() {
        if (classifications == null)
            classifications = new MutableLiveData<>();
        classificationCollection.get()
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        classifications.setValue(task.getResult().toObjects(Classification.class));
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

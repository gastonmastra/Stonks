package com.example.stonks.database.repository.firebase;

import com.example.stonks.database.entities.Classification;
import com.example.stonks.database.repository.interfaces.IClassificationRepository;
import com.example.stonks.database.repository.room.ClassificationRepositoryRoom;

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
        return null;
    }

    @Override
    public Classification getClassification(int classificationId) {
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

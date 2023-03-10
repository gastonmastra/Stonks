package com.example.stonks.database.repository.room;

import androidx.lifecycle.MutableLiveData;

import com.example.stonks.database.repository.room.daos.ClassificationDao;
import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.interfaces.IClassificationRepository;

import java.util.List;

public class ClassificationRepositoryRoom implements IClassificationRepository {
    private static ClassificationRepositoryRoom instance;
    private final ClassificationDao dao;

    private ClassificationRepositoryRoom(ClassificationDao dao) {
        this.dao = dao;
    }

    public static ClassificationRepositoryRoom getInstance(ClassificationDao dao){
        if (instance == null){
            instance = new ClassificationRepositoryRoom(dao);
        }
        return instance;
    }

    @Override
    public MutableLiveData<List<Classification>> getAllClassifications() {
        return null;
    }

    @Override
    public Classification getClassification(String name) {
        return dao.getClassification(name);
    }

    @Override
    public void insertClassification(Classification classification) {
        dao.insertClassification(classification);
    }

    @Override
    public void deleteClassification(Classification classification) {
        dao.deleteClassification(classification);
    }

    @Override
    public void updateClassification(Classification classification) {
        dao.updateClassification(classification);
    }
}

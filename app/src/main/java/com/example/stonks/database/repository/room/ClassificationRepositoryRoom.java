package com.example.stonks.database.repository.room;

import com.example.stonks.database.daos.ClassificationDao;
import com.example.stonks.database.daos.entities.Classification;
import com.example.stonks.database.repository.interfaces.IClasificationRepository;

import java.util.List;

public class ClassificationRepositoryRoom implements IClasificationRepository {
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
    public List<Classification> getAllClasifications() {
        return dao.getClassifications();
    }

    @Override
    public Classification getClasification(int clasificationId) {
        return dao.getClassification(clasificationId);
    }

    @Override
    public void insertClasification(Classification clasification) {
        dao.insertClassification(clasification);
    }

    @Override
    public void deleteClasification(Classification clasification) {
        dao.deleteClassification(clasification);
    }

    @Override
    public void updateClasification(Classification clasification) {
        dao.updateClassification(clasification);
    }
}

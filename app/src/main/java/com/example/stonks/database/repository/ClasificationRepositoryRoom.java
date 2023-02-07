package com.example.stonks.database.repository;

import com.example.stonks.database.daos.ClasificationDao;
import com.example.stonks.database.entities.Clasification;
import com.example.stonks.database.repository.interfaces.IClasificationRepository;

import java.util.List;

public class ClasificationRepositoryRoom implements IClasificationRepository {

    ClasificationDao dao;

    public ClasificationRepositoryRoom(ClasificationDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Clasification> getAllClasifications() {
        return null;
    }

    @Override
    public Clasification getClasification(int clasificationId) {
        return null;
    }

    @Override
    public void insertClasification(Clasification clasification) {

    }

    @Override
    public void deleteClasification(Clasification clasification) {

    }

    @Override
    public void updateClasification(Clasification clasification) {

    }
}

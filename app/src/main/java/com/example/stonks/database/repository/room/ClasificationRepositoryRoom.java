package com.example.stonks.database.repository.room;

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
        return dao.getClasifications();
    }

    @Override
    public Clasification getClasification(int clasificationId) {
        return dao.getClasification(clasificationId);
    }

    @Override
    public void insertClasification(Clasification clasification) {
        dao.insertClasification(clasification);
    }

    @Override
    public void deleteClasification(Clasification clasification) {
        dao.deleteClasification(clasification);
    }

    @Override
    public void updateClasification(Clasification clasification) {
        dao.updateClasification(clasification);
    }
}

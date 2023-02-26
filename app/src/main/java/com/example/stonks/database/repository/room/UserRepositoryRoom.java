package com.example.stonks.database.repository.room;

import com.example.stonks.database.repository.room.daos.UserDao;
import com.example.stonks.database.repository.room.entities.User;
import com.example.stonks.database.repository.interfaces.IUserRepository;

import java.util.List;

public class UserRepositoryRoom implements IUserRepository {
    private static UserRepositoryRoom instance;
    private final UserDao dao;

    private UserRepositoryRoom (UserDao dao){
        this.dao = dao;
    }

    public static UserRepositoryRoom getInstance(UserDao dao) {
        if (instance == null){
            instance = new UserRepositoryRoom(dao);
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getUsers();
    }

    @Override
    public User getUser(int userId) {
        return dao.getUser(userId);
    }

    @Override
    public void insertUser(User user) {
        dao.insertUser(user);
    }

    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
}

package com.example.stonks.database.repository;

import com.example.stonks.database.daos.UserDao;
import com.example.stonks.database.entities.User;
import com.example.stonks.database.repository.interfaces.IUserRepository;

import java.util.List;

public class UserRepositoryRoom implements IUserRepository {

    UserDao dao;

    public UserRepositoryRoom(UserDao dao) {
        this.dao = dao;
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

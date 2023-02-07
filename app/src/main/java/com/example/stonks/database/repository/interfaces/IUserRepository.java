package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.entities.User;

import java.util.List;

public interface IUserRepository {
    List<User> getAllUsers();
    User getUser(int userId);
    void insertUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
}

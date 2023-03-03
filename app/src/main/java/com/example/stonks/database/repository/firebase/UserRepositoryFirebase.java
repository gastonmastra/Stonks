package com.example.stonks.database.repository.firebase;

import com.example.stonks.database.repository.room.entities.User;
import com.example.stonks.database.repository.interfaces.IUserRepository;

import java.util.List;

public class UserRepositoryFirebase implements IUserRepository {
    private static UserRepositoryFirebase instance;

    public static UserRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new UserRepositoryFirebase();
        }
        return instance;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUser(int userId) {
        return null;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }
}

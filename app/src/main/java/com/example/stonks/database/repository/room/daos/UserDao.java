package com.example.stonks.database.repository.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.repository.room.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user")
    List<User> getUsers();

    @Query("SELECT * FROM user WHERE UserId = :userId")
    User getUser(int userId);

    @Insert
    void insertUser(User...user);

    @Delete
    void deleteUser(User user);

    @Update
    void updateUser(User user);

}

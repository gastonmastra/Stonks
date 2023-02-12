package com.example.stonks.database.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    public void setUserId(int userId) {
        UserId = userId;
    }

    @PrimaryKey(
            autoGenerate = true
    )
    private int UserId;
    private String Username;
    private String Password;

    public User(){ }

    public int getUserId() {
        return UserId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

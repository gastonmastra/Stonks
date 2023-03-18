package com.example.stonks.entities;

public class User {

    public void setUserId(int userId) {
        UserId = userId;
    }

    public int UserId;
    public String Username;
    public String Password;

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

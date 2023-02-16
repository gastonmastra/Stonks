package com.example.stonks.database;

public class Firebase {
    private static Firebase instance;
    private Firebase() { }
    public static Firebase getInstance(){
        if (instance == null){
            instance = new Firebase();
        }
        return instance;
    }
}

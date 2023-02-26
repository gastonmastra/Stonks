package com.example.stonks.database.repository.room.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.stonks.database.repository.room.entities.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Query("SELECT * FROM Persons")
    List<Person> getAllPersons();
    @Query("SELECT * FROM Persons WHERE person_id = :personId")
    Person getPerson(int personId);
    @Insert
    void insertPerson(Person person);
    @Update
    void updatePerson(Person person);
    @Delete
    void deletePerson(Person person);
}

package com.example.stonks.database.repository.interfaces;

import com.example.stonks.database.entities.Person;

import java.util.List;

public interface IPersonRepository {
    List<Person> getAllPersons();
    Person getPerson(int personId);
    void insertPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(Person person);
}

package com.example.stonks.database.repository.firebase;

import com.example.stonks.database.repository.room.entities.Person;
import com.example.stonks.database.repository.interfaces.IPersonRepository;

import java.util.List;

public class PersonRepositoryFirebase implements IPersonRepository {
    private static PersonRepositoryFirebase instance;

    public static PersonRepositoryFirebase getInstance(){
        if (instance == null){
            instance = new PersonRepositoryFirebase();
        }
        return instance;
    }

    @Override
    public List<Person> getAllPersons() {
        return null;
    }

    @Override
    public Person getPerson(int personId) {
        return null;
    }

    @Override
    public void insertPerson(Person person) {

    }

    @Override
    public void updatePerson(Person person) {

    }

    @Override
    public void deletePerson(Person person) {

    }
}

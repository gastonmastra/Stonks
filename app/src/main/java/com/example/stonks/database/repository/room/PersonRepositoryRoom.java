package com.example.stonks.database.repository.room;

import com.example.stonks.database.daos.PersonDao;
import com.example.stonks.database.entities.Person;
import com.example.stonks.database.repository.interfaces.IPersonRepository;

import java.util.List;

public class PersonRepositoryRoom implements IPersonRepository {
    PersonDao dao;

    public PersonRepositoryRoom(PersonDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Person> getAllPersons() {
        return dao.getAllPersons();
    }

    @Override
    public Person getPerson(int personId) {
        return dao.getPerson(personId);
    }

    @Override
    public void insertPerson(Person person) {
        dao.insertPerson(person);
    }

    @Override
    public void updatePerson(Person person) {
        dao.updatePerson(person);
    }

    @Override
    public void deletePerson(Person person) {
        dao.deletePerson(person);
    }
}

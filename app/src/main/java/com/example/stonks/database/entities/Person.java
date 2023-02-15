package com.example.stonks.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Persons")
public class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    public int PersonId;
    public String Name;
    public String Surname;
    public Double Debt;

    public Person(){}

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Double getDebt() {
        return Debt;
    }

    public void setDebt(Double debt) {
        Debt = debt;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

}

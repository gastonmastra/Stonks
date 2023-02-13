package com.example.stonks.database.daos.entities;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Classifications")
public class Classification {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "classification_id")
    private int ClassificationId;
    private String Description;
    private String Name;

    public Classification(){}

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getClassificationId() {
        return ClassificationId;
    }

    public void setClassificationId(int clasificationId) {
        ClassificationId = clasificationId;
    }

}

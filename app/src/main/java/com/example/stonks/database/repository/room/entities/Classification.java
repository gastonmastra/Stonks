package com.example.stonks.database.repository.room.entities;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Classifications")
public class Classification {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "classification_id")
    public int classificationId;
    public String description;
    public String name;

    public Classification(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassificationId() {
        return classificationId;
    }

    public void setClassificationId(int classificationId) {
        this.classificationId = classificationId;
    }

    @NonNull
    public String toString(){
        return getName();
    }

}

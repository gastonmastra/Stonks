package com.example.stonks.database.entities;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Clasifications")
public class Clasification {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "clasification_id")
    private int ClasificationId;
    private String Description;
    private String Name;

    public Clasification(){}

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

    public int getClasificationId() {
        return ClasificationId;
    }

    public void setClasificationId(int clasificationId) {
        ClasificationId = clasificationId;
    }

}

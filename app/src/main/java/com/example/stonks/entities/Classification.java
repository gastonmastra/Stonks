package com.example.stonks.entities;
import androidx.annotation.NonNull;

public class Classification {
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

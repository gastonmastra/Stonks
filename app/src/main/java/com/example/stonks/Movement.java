package com.example.stonks;

import androidx.annotation.Nullable;


public interface Movement {
    String Description;
    Boolean IsDebt;
    Double Mount;

    Clasification Clasification;
    @Nullable
    Person Person;

    public Movement(String description, Boolean isDebt, Double mount) {
        this.Description = description;
        this.IsDebt = isDebt;
        this.Mount = mount;
    }
}

package com.example.stonks;

import androidx.annotation.Nullable;


public class Movement {
    String Description;
    Boolean IsDebt;
    Double Mount;

    MovementType MovementType;
    Clasification Clasification;
    @Nullable
    Person Person;

    public Movement(String description, Boolean isDebt, Double mount) {
        this.Description = description;
        this.IsDebt = isDebt;
        this.Mount = mount;
    }
}

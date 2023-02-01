package com.example.stonks;

import androidx.annotation.Nullable;


public class Movement {
    String Description = null;
    Boolean IsDebt = null;
    Double Mount = null;

    Clasification Clasification = null;
    @Nullable
    Person Person = null;

    public Movement(String description, boolean isDebt, double mount){
    Description = description;
    IsDebt = isDebt;
    Mount = mount;
    }



}

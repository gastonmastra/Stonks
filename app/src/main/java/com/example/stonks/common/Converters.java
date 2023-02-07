package com.example.stonks.common;

import androidx.room.TypeConverter;

import com.example.stonks.database.entities.Wallet;

import java.util.Date;

public class Converters {

    @TypeConverter
    public static Date fromTimestamp (Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long datoToTimestamp (Date date){
        return date == null ? null : date.getTime();
    }
}

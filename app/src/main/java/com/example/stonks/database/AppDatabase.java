package com.example.stonks.database;

import static com.example.stonks.database.Migrations.Migration_2_3;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.stonks.common.Converters;
import com.example.stonks.database.daos.UserDao;
import com.example.stonks.database.entities.Clasification;
import com.example.stonks.database.entities.Movement;
import com.example.stonks.database.entities.User;

@Database(
        entities = { User.class, Movement.class, Clasification.class },
        version = 5,
        exportSchema = true,
        autoMigrations = {
                @AutoMigration(from = 1, to = 2),
                @AutoMigration(from = 3, to = 4, spec = Migrations.Migration_3_4.class),
        }
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase Instance;

    public static AppDatabase getInstance(Context context){
        if (Instance == null){
            Instance = Room.databaseBuilder(context, AppDatabase.class, "pruebaDb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .addMigrations(Migration_2_3)
                    .build();
        }
        return Instance;
    }

    public abstract UserDao userDao();

}

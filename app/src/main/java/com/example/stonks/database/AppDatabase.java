package com.example.stonks.database;

import static com.example.stonks.database.Migrations.Migration_2_3;

import android.content.Context;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.stonks.common.Converters;
import com.example.stonks.database.daos.ClassificationDao;
import com.example.stonks.database.daos.FixedExpenseDao;
import com.example.stonks.database.daos.FixedExpenseDetailDao;
import com.example.stonks.database.daos.MovementDao;
import com.example.stonks.database.daos.PersonDao;
import com.example.stonks.database.daos.UserDao;
import com.example.stonks.database.daos.WalletDao;
import com.example.stonks.database.daos.entities.Classification;
import com.example.stonks.database.daos.entities.FixedExpense;
import com.example.stonks.database.daos.entities.FixedExpenseDetail;
import com.example.stonks.database.daos.entities.Movement;
import com.example.stonks.database.daos.entities.Person;
import com.example.stonks.database.daos.entities.User;
import com.example.stonks.database.daos.entities.Wallet;

@Database(
        entities = {
                User.class, Movement.class, Classification.class, FixedExpense.class,
                FixedExpenseDetail.class, Person.class, Wallet.class
        },
        version = 6,
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
    public abstract MovementDao movementDao();
    public abstract ClassificationDao classificationDao();
    public abstract FixedExpenseDao fixedExpenseDao();
    public abstract FixedExpenseDetailDao fixedExpenseDetailDao();
    public abstract PersonDao personDao();
    public abstract WalletDao walletDao();

}

package com.example.stonks.database.repository.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.stonks.common.Converters;
import com.example.stonks.database.repository.room.daos.ClassificationDao;
import com.example.stonks.database.repository.room.daos.FixedExpenseDao;
import com.example.stonks.database.repository.room.daos.FixedExpenseDetailDao;
import com.example.stonks.database.repository.room.daos.MovementDao;
import com.example.stonks.database.repository.room.daos.PersonDao;
import com.example.stonks.database.repository.room.daos.UserDao;
import com.example.stonks.database.repository.room.daos.WalletDao;
import com.example.stonks.database.repository.room.entities.Classification;
import com.example.stonks.database.repository.room.entities.FixedExpense;
import com.example.stonks.database.repository.room.entities.FixedExpenseDetail;
import com.example.stonks.database.repository.room.entities.Movement;
import com.example.stonks.database.repository.room.entities.Person;
import com.example.stonks.database.repository.room.entities.User;
import com.example.stonks.database.repository.room.entities.Wallet;

@Database(
        entities = {
                User.class, Movement.class, Classification.class, FixedExpense.class,
                FixedExpenseDetail.class, Person.class, Wallet.class
        },
        version = 1
)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public static AppDatabase Instance;

    public static AppDatabase getInstance(Context context){
        if (Instance == null){
            Instance = Room.databaseBuilder(context, AppDatabase.class, "pruebaDb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
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

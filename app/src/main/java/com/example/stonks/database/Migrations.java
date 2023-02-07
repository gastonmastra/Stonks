package com.example.stonks.database;

import androidx.annotation.NonNull;
import androidx.room.RenameColumn;
import androidx.room.RenameTable;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class Migrations {

    static final Migration Migration_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS Clasifications (" +
                    "`clasification_id` INT PRIMARY KEY NOT NULL," +
                    "`name` TEXT," +
                    "`description` TEXT)");
        }
    };

    @RenameColumn(tableName = "Clasifications", fromColumnName = "ClasificationId", toColumnName = "clasification_id")
    static class Migration_3_4 implements AutoMigrationSpec{}
}

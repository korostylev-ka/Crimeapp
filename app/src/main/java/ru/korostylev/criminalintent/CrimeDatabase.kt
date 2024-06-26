package ru.korostylev.criminalintent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

//2 этап. Создаем класс базы данных и указываем сущности и конвертеры
@Database(entities = [Crime::class], version = 2)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDatabase: RoomDatabase() {
    //регистрируем DAO в базе данных
    abstract fun crimeDao(): CrimeDao

    companion object {
        private var instance: CrimeDatabase? = null

        fun getInstance(context: Context): CrimeDatabase {
            return instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            CrimeDatabase::class.java,
            "crime-database"
        )
            .addMigrations(migration_1_2)
            .build()
    }
}

//создаем миграцию после добавления поля имени подозреваемого
val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE Crime ADD COLUMN suspect TEXT NOT NULL DEFAULT ''"
        )
    }


}
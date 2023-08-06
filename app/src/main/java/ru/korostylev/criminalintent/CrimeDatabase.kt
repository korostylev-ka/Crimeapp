package ru.korostylev.criminalintent

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//2 этап. Создаем класс базы данных и указываем сущности и конвертеры
@Database(entities = [Crime::class], version = 1)
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
        ).build()
    }
}
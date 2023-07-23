package ru.korostylev.criminalintent

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

//2 этап. Создаем класс базы данных и указываем сущности и конвертеры
@Database(entities = [CrimeEntity::class], version = 1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDB: RoomDatabase() {
    //регистрируем DAO в базе данных
    abstract fun crimeDao(): CrimeDao
}
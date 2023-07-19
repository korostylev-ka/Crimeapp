package ru.korostylev.criminalintent

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [CrimeEntity::class], version = 1)
@TypeConverters(CrimeTypeConverters::class)
abstract class CrimeDB: RoomDatabase() {
}
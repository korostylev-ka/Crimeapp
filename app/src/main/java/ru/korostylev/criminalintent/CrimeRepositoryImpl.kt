package ru.korostylev.criminalintent

import android.content.Context
import androidx.room.Room
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepositoryImpl(context: Context): CrimeRepository {
    companion object {
        private var instance: CrimeRepository? = null
    }
    override fun initialize(context: Context) {
        if (instance == null) {
            instance = CrimeRepositoryImpl(context)
        }
    }

    override fun get(): CrimeRepository {
        return instance?: throw java.lang.IllegalStateException("CrimeRepository must be initialized")
    }

    //создаем конкретную реализацию абстрактного класса CrimeDB
    private val database: CrimeDB = Room.databaseBuilder(
        context.applicationContext,
        CrimeDB::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    fun getCrimes(): List<Crime> = crimeDao.getCrimes()

    fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)
}
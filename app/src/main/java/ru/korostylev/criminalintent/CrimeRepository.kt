package ru.korostylev.criminalintent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.UUID

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) {

    //создаем конкретную реализацию абстрактного класса CrimeDB
    private val database: CrimeDB = Room.databaseBuilder(
        context.applicationContext,
        CrimeDB::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

    //fun getCrimes(): List<Crime> = crimeDao.getCrimes()
    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    //fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)
    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)
    companion object {
        private var instance: CrimeRepository? = null

        fun initialize(context: Context) {
            if (instance == null) {
                instance = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return instance
                ?: throw java.lang.IllegalStateException("CrimeRepository must be initialized")
        }
    }




}
package ru.korostylev.criminalintent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.UUID
import java.util.concurrent.Executor
import java.util.concurrent.Executors

//private const val DATABASE_NAME = "crime-database"

class CrimeRepository (context: Context, private val crimeDao: CrimeDao) {

    //создаем конкретную реализацию абстрактного класса CrimeDB
    /*private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext,
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()*/
    private val executor = Executors.newSingleThreadExecutor()

    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)

    fun updateCrime(crime: Crime) {
        executor.execute {
            crimeDao.updateCrime(crime)
        }
    }

    fun addCrime(crime: Crime) {
        executor.execute {
            crimeDao.addCrime(crime)
        }
    }

    companion object {
        private var instance: CrimeRepository? = null

        fun initialize(context: Context) {
            if (instance == null) {
                instance = CrimeRepository(context, CrimeDatabase.getInstance(context).crimeDao())
            }
        }

        fun get(): CrimeRepository {
            return instance
                ?: throw java.lang.IllegalStateException("CrimeRepository must be initialized")
        }
    }




}
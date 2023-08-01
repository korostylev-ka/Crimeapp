package ru.korostylev.criminalintent

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

//3 этап. Создаем объект доступа к данным.
@Dao
interface CrimeDao {
    @Query("SELECT * FROM CrimeEntity")
    //выполнялось в основном потоке
    //fun getCrimes(): List<Crime>
    fun getCrimes(): LiveData<List<Crime>>
    @Query("SELECT * FROM CrimeEntity WHERE id= (:id)")
    //выполнялось в основном потоке
    //fun getCrime(id: UUID): Crime?
    fun getCrime(id: UUID): LiveData<Crime?>
}
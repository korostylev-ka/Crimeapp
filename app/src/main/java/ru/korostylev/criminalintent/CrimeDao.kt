package ru.korostylev.criminalintent

import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

@Dao
interface CrimeDao {
    @Query("SELECT * FROM CrimeEntity")
    fun getCrimes(): List<Crime>
    @Query("SELECT * FROM CrimeEntity WHERE id= (:id)")
    fun getCrime(id: UUID): Crime?
}
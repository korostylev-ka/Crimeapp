package ru.korostylev.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class CrimeEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    var title: String = "",
    //задает текущую дату
    var date: Date = Date(),
    var isSolved: Boolean = false
)
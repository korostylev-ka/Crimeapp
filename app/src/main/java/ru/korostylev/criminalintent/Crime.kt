package ru.korostylev.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

//1 этап. определяем "сущность"(классы моделей) аннотацией
@Entity
data class Crime(
    @PrimaryKey
    var id: UUID = UUID.randomUUID(),
    var title: String = "",
    //задает текущую дату
    var date: Date = Date(),
    var isSolved: Boolean = false,
    //имя подозреваемого
    var suspect: String = ""
)
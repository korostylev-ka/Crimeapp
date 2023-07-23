package ru.korostylev.criminalintent

import java.util.Date
import java.util.UUID

data class Crime(
    //способ генерирования универсально-уникальных идентификаторов
    var id: UUID = UUID.randomUUID(),
    var title: String = "",
    //задает текущую дату
    var date: Date = Date(),
    var isSolved: Boolean = false
)
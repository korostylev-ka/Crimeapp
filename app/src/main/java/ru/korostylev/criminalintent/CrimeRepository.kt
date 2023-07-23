package ru.korostylev.criminalintent

import android.content.Context

interface CrimeRepository {

    fun initialize(context: Context): Unit

    fun get(): CrimeRepository

}
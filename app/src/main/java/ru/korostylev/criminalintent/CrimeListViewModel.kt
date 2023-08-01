package ru.korostylev.criminalintent

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel

class CrimeListViewModel(): ViewModel() {
    //val crimes = mutableListOf<Crime>()


    /*init {
        for (i in 0 until 100) {
            val crime = Crime()
            crime.title = "Crime №$i"
            crime.isSolved = i % 2 == 0
            crimes += crime
        }
    }*/
    private val crimeRepository = CrimeRepository.get()
    val crimes = crimeRepository.getCrimes()
    val crimeListLiveData = crimeRepository.getCrimes()
}
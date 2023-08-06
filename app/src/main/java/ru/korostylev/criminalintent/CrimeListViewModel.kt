package ru.korostylev.criminalintent

import android.app.Activity
import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel

class CrimeListViewModel(): ViewModel() {

    private val crimeRepository = CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

}
package ru.korostylev.criminalintent

import android.app.Application

//создаем подкласс приложения и прописываем его в манифесте (android:name)
class CriminalIntentApplication: Application() {
    //private val repository = CrimeRepositoryImpl(applicationContext)
    override fun onCreate() {
        super.onCreate()
        //инициализируется при запуске приложения
        CrimeRepository.initialize(this)
    }
}
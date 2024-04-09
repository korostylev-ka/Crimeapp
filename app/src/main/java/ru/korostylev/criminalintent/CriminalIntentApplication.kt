package ru.korostylev.criminalintent

import android.app.Application
import android.util.Log

//создаем подкласс приложения и прописываем его в манифесте (android:name)
class CriminalIntentApplication: Application() {
    //private val repository = CrimeRepositoryImpl(applicationContext)
    override fun onCreate() {
        Log.d("Application_","OnCreate()")
        super.onCreate()
        //инициализируется при запуске приложения
        CrimeRepository.initialize(this)
    }


}
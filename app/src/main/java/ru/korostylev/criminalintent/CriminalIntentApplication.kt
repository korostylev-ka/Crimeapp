package ru.korostylev.criminalintent

import android.app.Application
import android.content.Context

//создаем подкласс приложения и прописываем его в манифесте (android:name)
class CriminalIntentApplication: Application() {
    //private val repository = CrimeRepositoryImpl(applicationContext)
    override fun onCreate() {
        super.onCreate()
        CrimeRepositoryImpl(this).initialize(this)
    }
}
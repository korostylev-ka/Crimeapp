package ru.korostylev.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import java.util.*

class MainActivity : AppCompatActivity(), CrimeListFragment.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)

        if (currentFragment == null) {
            val fragment = CrimeListFragment.newInstance()
            supportFragmentManager
                    //создать новую транзакцию фрагмента
                .beginTransaction()
                    //включить одну операцию добавления
                .add(R.id.fragment_container, fragment)
                    //закрепить
                .commit()
        }
    }

    override fun onCrimeSelected(crimeId: UUID) {
//        Log.d("UUID", "$crimeId")
        val fragment = CrimeFragment.newInstance(crimeId)
//        val fragment = CrimeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
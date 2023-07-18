package ru.korostylev.criminalintent

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withContext

class CrimeHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
    private lateinit var crime: Crime
    private val idTextView: TextView = itemView.findViewById(R.id.crime_id)
    private val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(crime: Crime) {
        this.crime = crime
        titleTextView.text = this.crime.title
        dateTextView.text = this.crime.date.toString()
    }

    override fun onClick(v: View) {
        Toast.makeText(v.context, "${crime.title} pressed", Toast.LENGTH_SHORT)
            .show()
    }
}
package ru.korostylev.criminalintent

import android.app.Application
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.withContext
import java.text.DateFormat

class CrimeHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
    private lateinit var crime: Crime
    private val idTextView: TextView = itemView.findViewById(R.id.crime_id)
    private val titleTextView: TextView = itemView.findViewById(R.id.crime_title)
    private val dateTextView: TextView = itemView.findViewById(R.id.crime_date)
    private val solvedImageView: ImageView = itemView.findViewById(R.id.crime_solved)

    init {
        itemView.setOnClickListener(this)
    }

    fun bind(crime: Crime) {
        this.crime = crime
        titleTextView.text = this.crime.title
        dateTextView.text = this.crime.date.toString()
        solvedImageView.visibility = if (crime.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }

    override fun onClick(v: View) {
        Toast.makeText(v.context, "${crime.title} pressed", Toast.LENGTH_SHORT)
            .show()
    }
}
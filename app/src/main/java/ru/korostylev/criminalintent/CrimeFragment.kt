package ru.korostylev.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment

//контроллер, взаимодействующий с объектами модели и представления. Его задача - выдача подробной
//информации о конкретном преступлении и ее обновление при модификации пользователем
class CrimeFragment: Fragment() {

    private lateinit var crime: Crime
    private lateinit var titleField: EditText
    private lateinit var dateButton: Button
    private lateinit var solvedCheckBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        dateButton = view.findViewById(R.id.crime_date) as Button
        solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
        }

        solvedCheckBox.apply {
            setOnCheckedChangeListener {_,isChecked ->
                crime.isSolved = isChecked

            }
        }
        return view
    }

    override fun onStart() {
        super.onStart()

        //добавление слушателя к виджету EditText. Анонимный класс, который реализует интерфейс
        // слушателя TextWatcher
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(
                sequence: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
                //вызываем toString для объекта CharSequence, представляющего ввод пользователя
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {
                TODO("Not yet implemented")
            }
        }

        titleField.addTextChangedListener(titleWatcher)
    }


}
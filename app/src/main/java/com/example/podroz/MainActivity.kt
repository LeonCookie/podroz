package com.example.podroz

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextPaint
import android.util.Log
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

lateinit var TexTPocz: TextView
lateinit var TexTSRD: TextView
lateinit var TexTKon: TextView

lateinit var ButtonPocz: Button
lateinit var ButtonSRD: Button
lateinit var ButtonKon: Button

lateinit var Suwak: SeekBar
lateinit var TexTSuw: TextView




//Calendars and buttons
var First: String = ""
var Second: String = ""
var Third: String = ""

val MyClanedar = Calendar.getInstance()


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Suwak = findViewById<SeekBar>(R.id.seekBar)
        TexTSuw = findViewById<TextView>(R.id.textViewSuwak)

        TexTPocz = findViewById<TextView>(R.id.textViewPocz)
        TexTSRD  = findViewById<TextView>(R.id.textViewSRD)
        TexTKon  = findViewById<TextView>(R.id.textViewKon)

        ButtonPocz = findViewById<Button>(R.id.ButtonPocz)
        ButtonSRD = findViewById<Button>(R.id.ButtonSrd)
        ButtonKon = findViewById<Button>(R.id.ButtonKon)


        val DatePicker1 = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            MyClanedar.set(Calendar.YEAR,year)
            MyClanedar.set(Calendar.MONTH,month)
            MyClanedar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(MyClanedar)

        }
        val DatePicker2 = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            MyClanedar.set(Calendar.YEAR,year)
            MyClanedar.set(Calendar.MONTH,month)
            MyClanedar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable2(MyClanedar)

        }
        val DatePicker3 = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

            MyClanedar.set(Calendar.YEAR,year)
            MyClanedar.set(Calendar.MONTH,month)
            MyClanedar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable3(MyClanedar)

        }


        ButtonPocz.setOnClickListener{
            DatePickerDialog(this,DatePicker1, MyClanedar.get(Calendar.YEAR), MyClanedar.get(Calendar.MONTH),
                MyClanedar.get(Calendar.DAY_OF_MONTH)).show()

        }
        ButtonSRD.setOnClickListener{
            DatePickerDialog(this,DatePicker2, MyClanedar.get(Calendar.YEAR), MyClanedar.get(Calendar.MONTH),
                MyClanedar.get(Calendar.DAY_OF_MONTH)).show()


        }
         ButtonKon.setOnClickListener{
            DatePickerDialog(this,DatePicker3, MyClanedar.get(Calendar.YEAR), MyClanedar.get(Calendar.MONTH),
                MyClanedar.get(Calendar.DAY_OF_MONTH)).show()

        }


















        var a:Float//zmienna w seekbar

        Suwak.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,fromUser: Boolean) {




                a = (progress.toFloat())
                a=a/10
                TexTSuw.text = a.toString()



            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

    }

    private fun updateLable(myClanedar: Calendar) {
        val MyFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(MyFormat, Locale.GERMAN)
        TexTPocz.setText(sdf.format(MyClanedar.time))
        First = (sdf.format(MyClanedar.time))
    }
    private fun updateLable2(myClanedar: Calendar) {
        val MyFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(MyFormat, Locale.GERMAN)
        TexTSRD.setText(sdf.format(MyClanedar.time))
        Second = (sdf.format(MyClanedar.time))
    }
    private fun updateLable3(myClanedar: Calendar) {
        val MyFormat="dd-MM-yyyy"
        val sdf=SimpleDateFormat(MyFormat, Locale.GERMAN)
        TexTKon.setText(sdf.format(MyClanedar.time))
        Third = (sdf.format(MyClanedar.time))
    }
}
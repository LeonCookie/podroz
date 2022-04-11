package com.example.podroz

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextPaint
import android.text.TextWatcher
import android.util.Log
import android.widget.*
import java.lang.Math.abs
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

lateinit var TexTPocz: TextView
lateinit var TexTSRD: TextView
lateinit var TexTKon: TextView

lateinit var ButtonPocz: Button
lateinit var ButtonSRD: Button
lateinit var ButtonKon: Button

lateinit var Suwak: SeekBar
lateinit var TexTSuw: TextView
lateinit var EditSym: EditText
lateinit var BSym: Button

lateinit var MainCalender: CalendarView




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
        EditSym = findViewById<EditText>(R.id.editTextSym)
        BSym = findViewById<Button>(R.id.buttonSym)

        TexTPocz = findViewById<TextView>(R.id.textViewPocz)
        TexTSRD  = findViewById<TextView>(R.id.textViewSRD)
        TexTKon  = findViewById<TextView>(R.id.textViewKon)

        ButtonPocz = findViewById<Button>(R.id.ButtonPocz)
        ButtonSRD = findViewById<Button>(R.id.ButtonSrd)
        ButtonKon = findViewById<Button>(R.id.ButtonKon)

        MainCalender = findViewById<CalendarView>(R.id.MainCalender)




        var Edit:String=""
        /*
        EditSym.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) =


                if(Edit.toInt()>10 && Edit.toInt() <20){

                    Edit = EditSym.getText().toString();
                    Suwak.setProgress(Edit.toFloat().toInt()/10)
                    TexTSuw.text = Edit.toString()
                }else{
                    Toast.makeText(this@MainActivity, "Liczba musi byc w przedziale od 1.0 do 2.0", Toast.LENGTH_SHORT).show()
                }




        })

         */




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





            //progresss








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

        /*
        BSym.setOnClickListener{



            val difference: Long = abs(FirstT.time - ThirdT.time)
            val differenceDates = difference / (24 * 60 * 60 * 1000)
            val dayDifference = differenceDates.toString()
            textView.text = "The difference between two dates is $dayDifference days"
        }
         */
    }




    //Private

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
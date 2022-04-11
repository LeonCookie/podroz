package com.example.podroz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var TexTPocz: TextView
        lateinit var TexTSRD: TextView
        lateinit var TexTKon: TextView

        lateinit var ButtonPocz: Button
        lateinit var ButtonSRD: Button
        lateinit var ButtonKon: Button

        lateinit var Suwak: SeekBar
        lateinit var TexTSuw: TextView

        Suwak = findViewById<SeekBar>(R.id.seekBar)
        TexTSuw = findViewById<TextView>(R.id.textViewSuwak)

        TexTPocz = findViewById<TextView>(R.id.textViewPocz)
        TexTSRD  = findViewById<TextView>(R.id.textViewSRD)
        TexTKon  = findViewById<TextView>(R.id.textViewKon)

        ButtonPocz = findViewById<Button>(R.id.ButtonPocz)




        var a:Float

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
}
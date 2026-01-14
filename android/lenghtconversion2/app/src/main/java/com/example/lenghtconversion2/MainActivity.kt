package com.example.lenghtconversion2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val TxtInput = findViewById<EditText>(R.id.txtInput)
        val RinchTocm=findViewById<RadioButton>(R.id.radioInchToCm)
        val RcmToinch=findViewById<RadioButton>(R.id.radioCmToInch)
        val BtnCalculate=findViewById<Button>(R.id.BtnCalculate)
        val TxtOutput=findViewById<TextView>(R.id.txtOutput)
   BtnCalculate.setOnClickListener {
   TxtOutput.setText("%.3f".format(if(RcmToinch.isChecked) TxtInput.text.toString().toDouble()/2.54 else
        TxtInput.text.toString().toDouble()*2.54))
   }



    }
}
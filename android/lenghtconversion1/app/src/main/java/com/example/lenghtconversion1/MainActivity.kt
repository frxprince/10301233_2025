package com.example.lenghtconversion1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
val TxtInput=findViewById<EditText>(R.id.TxtInput)
val BtnInchToCm=findViewById<Button>(R.id.BtnInchtoCm)
val BtnCmToInch=findViewById<Button>(R.id.BtnCmtoInch)
val TxtOutput=findViewById<TextView>(R.id.Txtoutput)
 BtnInchToCm.setOnClickListener {
     var ans:Double=  TxtInput.text.toString().toDouble()*2.54
  TxtOutput.setText(ans.toString()+" cm")
 }
BtnCmToInch.setOnClickListener {  // printf("%.2f",ans)
    TxtOutput.setText ("%.2f".format(TxtInput.text.toString().toDouble()/2.54)+
    " inch")  }
    }
}
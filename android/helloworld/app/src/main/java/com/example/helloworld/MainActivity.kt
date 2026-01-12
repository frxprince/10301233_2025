package com.example.helloworld

import android.os.Bundle
import android.util.Log
import android.widget.Button
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
    val ButtonHello: Button
    ButtonHello=findViewById(R.id.btnHello)
    val BtnExit=findViewById<Button>(R.id.btnExit)
    BtnExit.setOnClickListener { finish() }
    ButtonHello.setText("Click me")
    ButtonHello.setOnClickListener {
        ButtonHello.setText("Clicked!!!")
       Log.e("my program","Hello world Click!!!!")
       Log.w("my program","Warning Hello  ")

    }
        Log.e("my program","create!!!!!")
    }
    override fun onResume() {
        super.onResume()
        Log.e("my program","Focus!!!!!")
    }
}
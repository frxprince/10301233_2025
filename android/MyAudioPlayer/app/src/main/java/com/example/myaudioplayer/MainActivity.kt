package com.example.myaudioplayer

import android.os.Bundle
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
   val BtnLoadResource=findViewById<Button>(R.id.BtnResource)
   val BtnLoadAssets=findViewById<Button>(R.id.BtnAssets)
   val BtnLoadInternet=findViewById<Button>(R.id.BtnInternet)
   val BtnLoadSDCARD=findViewById<Button>(R.id.BtnSDCARD)
   val BtnPlay=findViewById<Button>(R.id.BtnPlay)
   val BtnPause=findViewById<Button>(R.id.BtnPause)
   val BtnStop=findViewById<Button>(R.id.BtnStop)
        
    }
}
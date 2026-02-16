package com.example.mypreferences

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
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
val BtnSave=findViewById<Button>(R.id.BtnSave)
val BtnLoad=findViewById<Button>(R.id.BtnLoad)
val BtnExit=findViewById<Button>(R.id.BtnExit)
val TxtField1=findViewById<EditText>(R.id.txtField1)
val TxtField2=findViewById<EditText>(R.id.txtField2)
BtnExit.setOnClickListener { finish() }
BtnSave.setOnClickListener {
    var pref=getSharedPreferences("my_data", Context.MODE_PRIVATE)
  pref.edit {
      putString("parameter1",TxtField1.text.toString())
      putString("parameter2",TxtField2.text.toString())
     commit()
  }
}
BtnLoad.setOnClickListener {
    var pref=getSharedPreferences("my_data", Context.MODE_PRIVATE)
    TxtField1.setText(pref.getString("parameter1","no data"))
    TxtField2.setText(pref.getString("parameter2","no data"))

}
    }
}
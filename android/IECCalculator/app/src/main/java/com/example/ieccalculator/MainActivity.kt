package com.example.ieccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
 val BtnInputUnit=findViewById<Button>(R.id.BtnInputUnit)
 val TxtBase=findViewById<TextView>(R.id.TxtBase)
 val BtnOutputUnit=findViewById<Button>(R.id.BtnOutputUnit)
 var BaseValue:Double=0.0
 val InputRes=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
     result: ActivityResult->
      if(result.resultCode == RESULT_OK){
   //    TxtBase.setText(result.data?.getStringExtra("prefix")?:"no data")
   BaseValue=when(result.data!!.getStringExtra("prefix")){
      "kB"-> TxtInput.text.toString().toDouble() * Math.pow(10.0,3.0)
      "MB"-> TxtInput.text.toString().toDouble() * Math.pow(10.0,6.0)
      "GB"-> TxtInput.text.toString().toDouble() * Math.pow(10.0,9.0)
      "TB"-> TxtInput.text.toString().toDouble() * Math.pow(10.0,12.0)
      else-> 0.0
  }
  TxtBase.setText(DecimalFormat("#,###,###.###").format(BaseValue) +" Bytes")
      }
 }
BtnInputUnit.setOnClickListener { val i= Intent(this, InputPrefiix::class.java)
 InputRes.launch(i)
}


    }
}
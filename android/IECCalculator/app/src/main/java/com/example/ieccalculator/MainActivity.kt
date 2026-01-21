package com.example.ieccalculator

import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            overrideActivityTransition(
                OVERRIDE_TRANSITION_OPEN,
                R.anim.fade_in, R.anim.fade_out
            )
        }else{
         overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }
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

val OutputRes=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
    result: ActivityResult->
     if(result.resultCode==RESULT_OK){
   var ans=when(result.data!!.getStringExtra("prefix")){
    "kiB"-> (BaseValue/Math.pow(2.0,10.0)).toString()+" kiB"
    "MiB"-> (BaseValue/Math.pow(2.0,20.0)).toString()+" MiB"
    "GiB"-> (BaseValue/Math.pow(2.0,30.0)).toString()+" GiB"
    "TiB"-> (BaseValue/Math.pow(2.0,40.0)).toString()+" TiB"
    else->"no data"
   }
   Log.v("the answer is ",ans.toString())
  val i=Intent(this, ShowResult::class.java)
  i.putExtra("result",ans.toString())
  startActivity(i)
     }
}
BtnOutputUnit.setOnClickListener { val i=Intent(this,TargetPrefix::class.java)
OutputRes.launch(i)}



    }
}
package com.example.ieccalculator

import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class InputPrefiix : AppCompatActivity() {
    override fun finish() {
        super.finish()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            overrideActivityTransition(
                OVERRIDE_TRANSITION_OPEN,
                R.anim.fade_in, R.anim.fade_out
            )
        }else{
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out)
        }
    }

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
        setContentView(R.layout.activity_input_prefiix)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    val BtnkB=findViewById<Button>(R.id.BtnkB)
    val BtnMB=findViewById<Button>(R.id.BtnMB)
    val BtnGB=findViewById<Button>(R.id.BtnGB)
    val BtnTB=findViewById<Button>(R.id.BtnTB)
    BtnkB.setOnClickListener {
        intent.putExtra("prefix","kB")
        setResult(RESULT_OK,intent)
        finish()
    }
    BtnMB.setOnClickListener {
        intent.putExtra("prefix","MB")
        setResult(RESULT_OK,intent)
        finish()
    }
   BtnGB.setOnClickListener {
       intent.putExtra("prefix","GB")
       setResult(RESULT_OK,intent)
       finish()
   }
   BtnTB.setOnClickListener {
       intent.putExtra("prefix","TB")
       setResult(RESULT_OK,intent)
       finish()
   }
    }
}
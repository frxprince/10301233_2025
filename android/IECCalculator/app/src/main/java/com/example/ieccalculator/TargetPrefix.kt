package com.example.ieccalculator

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TargetPrefix : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_target_prefix)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val BtnkiB=findViewById<Button>(R.id.BtnkiB)
        val BtnMiB=findViewById<Button>(R.id.BtnMiB)
        val BtnGiB=findViewById<Button>(R.id.BtnGiB)
        val BtnTiB=findViewById<Button>(R.id.BtnTiB)
        BtnkiB.setOnClickListener {
            intent.putExtra("prefix","kiB")
            setResult(RESULT_OK,intent)
            finish()
        }
        BtnMiB.setOnClickListener {
            intent.putExtra("prefix","MiB")
            setResult(RESULT_OK,intent)
            finish()
        }
        BtnGiB.setOnClickListener {
            intent.putExtra("prefix","GiB")
            setResult(RESULT_OK,intent)
            finish()
        }
        BtnTiB.setOnClickListener {
            intent.putExtra("prefix","TiB")
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}
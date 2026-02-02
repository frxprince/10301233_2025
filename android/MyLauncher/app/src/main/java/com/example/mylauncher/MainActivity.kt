package com.example.mylauncher

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
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
    val Listview1=findViewById<ListView>(R.id.listview1)
    val Txt1=findViewById<TextView>(R.id.Text1)
    val Txt2=findViewById<TextView>(R.id.Text2)
    val Btn=findViewById<Button>(R.id.Btn)
    var displayList=mutableListOf<String>()
    var package_list=packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
      for(item in package_list){
          Log.v("my application", item.packageName+","+item.className    )
          displayList.add(item.packageName)
      }
  val adapter= ArrayAdapter(this,R.layout.activity_listview_item,
      displayList.toTypedArray())
  Listview1.adapter=adapter
    }
}
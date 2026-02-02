package com.example.mylauncher

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat.enableEdgeToEdge
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    lateinit var Txt1: TextView
    lateinit var Txt2: TextView
    lateinit var Listview1:ListView
    lateinit var  Btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    Listview1=findViewById(R.id.listview1)
    Txt1=findViewById(R.id.Text1)
     Txt2=findViewById(R.id.Text2)
     Btn=findViewById(R.id.Btn)
    var displayList=mutableListOf<String>()
    var package_list=packageManager.getInstalledApplications(PackageManager.GET_META_DATA)
      for(item in package_list){
          Log.v("my application", item.packageName+","+item.className    )
          displayList.add(item.packageName)
      }
  val adapter= ArrayAdapter(this,R.layout.activity_listview_item,
      displayList.toTypedArray())
  Listview1.adapter=adapter
   Listview1.onItemClickListener=this
Btn.setOnClickListener {
  startActivity(packageManager.getLaunchIntentForPackage(Txt1.text.toString()))
}

  }

    override fun onItemClick(
        parent: AdapterView<*>?,
        view: View?,
        position: Int,
        id: Long
    ) {
        Txt1.text= Listview1.getItemAtPosition(position).toString()
   if (packageManager.getLaunchIntentForPackage(Txt1.text.toString()) !=null)
   {
      Btn.isEnabled=true
   Txt2.text=packageManager.getLaunchIntentForPackage(Txt1.text.toString()).toString()
   }else{
       Btn.isEnabled=false
       Txt2.text=""

   }
    }

}

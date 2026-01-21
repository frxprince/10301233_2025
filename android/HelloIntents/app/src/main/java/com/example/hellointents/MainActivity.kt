package com.example.hellointents

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log.i
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
 val BtnWeb=findViewById<Button>(R.id.BtnWeb)
        val BtnMap=findViewById<Button>(R.id.BtnMap)
        val BtnAlarm=findViewById<Button>(R.id.BtnAlarm)
        val BtnPhonebook=findViewById<Button>(R.id.Btnphonebook)
        val BtnCamera=findViewById<Button>(R.id.BtnCamera)
 BtnWeb.setOnClickListener {
  val i= Intent(Intent.ACTION_VIEW,Uri.parse("https://www.mju.ac.th"))

     try {
         startActivity(i)
     } catch (e: Exception) {
         BtnWeb.isEnabled=false
     }
 }

 BtnMap.setOnClickListener {
     val i= Intent(Intent.ACTION_VIEW,Uri.parse("geo:29.9796454,31.1333187"))
         startActivity(i)
 }
if(checkSelfPermission("com.android.alarm.permission.SET_ALARM")!=
    PackageManager.PERMISSION_GRANTED){
 requestPermissions(arrayOf("com.android.alarm.permission.SET_ALARM"),
     1234)
}

 BtnAlarm.setOnClickListener {
val i=Intent(AlarmClock.ACTION_SET_TIMER)
     i.putExtra(AlarmClock.EXTRA_MESSAGE,"Hello World")
     i.putExtra(AlarmClock.EXTRA_LENGTH,10)
     i.putExtra(AlarmClock.EXTRA_SKIP_UI,true)
     startActivity(i)
 }
BtnPhonebook.setOnClickListener {
    val i = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
    startActivity(i)
}
BtnCamera.setOnClickListener {
    val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
    startActivity(i)
}

    }
}
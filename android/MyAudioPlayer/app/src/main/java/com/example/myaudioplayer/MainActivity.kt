package com.example.myaudioplayer

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
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
lateinit var MP: MediaPlayer
   BtnLoadResource.setOnClickListener {

     MP= MediaPlayer.create(this,R.raw.greeting)
   }
   BtnLoadAssets.setOnClickListener {
    var afile=assets.openFd("audio/mp3/tada.mp3")
   MP= MediaPlayer()
   MP.setDataSource(afile.fileDescriptor,afile.startOffset,afile.length )
   MP.prepare()
   }
   BtnLoadInternet.setOnClickListener {
      //     https://www.drpaween.com/ohm/mp3test.mp3
    MP= MediaPlayer()
    MP.setDataSource(this,Uri.parse("http://www.drpaween.com/ohm/mp3test.mp3"))
    MP.prepare()
   }
if(ActivityCompat.checkSelfPermission(this,
        Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
    ActivityCompat.requestPermissions(this,
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),1234)
}
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),1234)
        }
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_MEDIA_AUDIO) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.READ_MEDIA_AUDIO),1234)
        }

BtnLoadSDCARD.setOnClickListener {
    MP= MediaPlayer()
  MP.setDataSource(Environment.getExternalStorageDirectory().path  +"/Music/song.mp3")
  MP.prepare()
}
   BtnPlay.setOnClickListener { MP.start() }
   BtnStop.setOnClickListener { MP.stop() }

    }
}
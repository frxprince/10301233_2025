package com.example.myvideoplayer

import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
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
val videoView=findViewById<VideoView>(R.id.videoView)
val btnLoadResource=findViewById<Button>(R.id.BtnResource)
val btnLoadInternet=findViewById<Button>(R.id.BtnInternet)
val btnLoadSDCARD=findViewById<Button>(R.id.BtnSDCARD)
val btnPlay=findViewById<Button>(R.id.BtnPlay)
val btnPause=findViewById<Button>(R.id.BtnPause)
val btnStop=findViewById<Button>(R.id.BtnStop)
btnLoadResource.setOnClickListener {
videoView.setVideoURI(Uri.parse("android.resource://"+packageName+"/"+R.raw.video2 ))
}
videoView.setMediaController(MediaController(this))
btnPlay.setOnClickListener { videoView.start() }
 btnStop.setOnClickListener { videoView.stopPlayback() }
 btnPause.setOnClickListener { videoView.pause() }
 btnLoadInternet.setOnClickListener {
     videoView.setVideoURI(
         Uri.parse("http://www.drpaween.com/ohm/cs436/mv.mp4"))
 }
 btnLoadSDCARD.setOnClickListener {
     videoView.setVideoURI(Uri.parse(Environment.getExternalStorageDirectory().path+
     "/DCIM/Loituma.3gp"))
 }
    }
}
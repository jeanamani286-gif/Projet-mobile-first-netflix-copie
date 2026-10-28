package com.example.streamingapp

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class PlayerActivity : AppCompatActivity() {

    private var isPlaying = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        val title = intent.getStringExtra("EXTRA_TITLE") ?: "Vidéo"
        val videoView = findViewById<VideoView>(R.id.videoView)
        val tvVideoTitle = findViewById<TextView>(R.id.tvVideoTitle)
        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnPlayPause = findViewById<ImageView>(R.id.btnPlayPause)

        tvVideoTitle.text = title

        btnBack.setOnClickListener {
            finish()
        }

        // Standard sample video URL or local resource
        val videoUri = Uri.parse("android.resource://$packageName/raw/sample_video")
        videoView.setVideoURI(videoUri)

        btnPlayPause.setOnClickListener {
            if (isPlaying) {
                videoView.pause()
                btnPlayPause.setImageResource(R.drawable.ic_play)
                isPlaying = false
            } else {
                videoView.start()
                btnPlayPause.setImageResource(R.drawable.ic_pause)
                isPlaying = true
            }
        }

        videoView.start()
    }
}

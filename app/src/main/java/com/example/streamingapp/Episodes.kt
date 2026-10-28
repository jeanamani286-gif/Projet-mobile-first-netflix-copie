package com.example.streamingapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EpisodesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episodes)

        val contentId = intent.getIntExtra("EXTRA_CONTENT_ID", -1)
        val content = FakeData.getContentById(contentId) ?: FakeData.popularSeries.first()

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val tvSeriesTitle = findViewById<TextView>(R.id.tvSeriesTitle)
        val rvEpisodes = findViewById<RecyclerView>(R.id.rvEpisodes)

        tvSeriesTitle.text = content.title
        btnBack.setOnClickListener {
            finish()
        }

        val episodeAdapter = EpisodeAdapter(content.episodes) { episode ->
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("EXTRA_CONTENT_ID", content.id)
                putExtra("EXTRA_TITLE", "${content.title} - ${episode.title}")
            }
            startActivity(intent)
        }

        rvEpisodes.layoutManager = LinearLayoutManager(this)
        rvEpisodes.adapter = episodeAdapter
    }
}

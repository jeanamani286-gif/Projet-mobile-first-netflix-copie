package com.example.streamingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    private var content: Content? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val contentId = intent.getIntExtra("EXTRA_CONTENT_ID", -1)
        content = FakeData.getContentById(contentId) ?: FakeData.featuredContent

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val ivBanner = findViewById<ImageView>(R.id.ivBanner)
        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvYear = findViewById<TextView>(R.id.tvYear)
        val tvRating = findViewById<TextView>(R.id.tvRating)
        val tvGenre = findViewById<TextView>(R.id.tvGenre)
        val tvDescription = findViewById<TextView>(R.id.tvDescription)
        val btnPlay = findViewById<Button>(R.id.btnPlay)
        val btnFavorite = findViewById<Button>(R.id.btnFavorite)
        val btnEpisodes = findViewById<Button>(R.id.btnEpisodes)

        btnBack.setOnClickListener {
            finish()
        }

        content?.let { c ->
            ivBanner.setImageResource(c.bannerResId)
            tvTitle.text = c.title
            tvYear.text = c.year.toString()
            tvRating.text = c.rating
            tvGenre.text = c.genre
            tvDescription.text = c.description

            if (c.type == ContentType.SERIES) {
                btnEpisodes.visibility = View.VISIBLE
            } else {
                btnEpisodes.visibility = View.GONE
            }

            updateFavoriteButtonState(btnFavorite, c.id)

            btnPlay.setOnClickListener {
                val intent = Intent(this, PlayerActivity::class.java).apply {
                    putExtra("EXTRA_CONTENT_ID", c.id)
                    putExtra("EXTRA_TITLE", c.title)
                }
                startActivity(intent)
            }

            btnFavorite.setOnClickListener {
                val added = FavoritesManager.toggleFavorite(c.id)
                updateFavoriteButtonState(btnFavorite, c.id)
                val msg = if (added) "Ajouté aux favoris" else "Retiré des favoris"
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            }

            btnEpisodes.setOnClickListener {
                val intent = Intent(this, EpisodesActivity::class.java).apply {
                    putExtra("EXTRA_CONTENT_ID", c.id)
                }
                startActivity(intent)
            }
        }
    }

    private fun updateFavoriteButtonState(button: Button, contentId: Int) {
        if (FavoritesManager.isFavorite(contentId)) {
            button.setText(R.string.details_remove_favorites)
        } else {
            button.setText(R.string.details_add_favorites)
        }
    }
}

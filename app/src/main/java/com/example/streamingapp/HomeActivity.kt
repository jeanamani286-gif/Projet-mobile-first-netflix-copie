package com.example.streamingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Hero Banner
        val featured = FakeData.featuredContent
        findViewById<TextView>(R.id.tvHeroTitle).text = featured.title
        findViewById<TextView>(R.id.tvHeroSubtitle).text = "${featured.type.name} • ${featured.genre} • ${featured.year}"

        findViewById<Button>(R.id.btnHeroPlay).setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java).apply {
                putExtra("EXTRA_CONTENT_ID", featured.id)
                putExtra("EXTRA_TITLE", featured.title)
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnHeroInfo).setOnClickListener {
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("EXTRA_CONTENT_ID", featured.id)
            }
            startActivity(intent)
        }

        // RecyclerViews
        setupRecyclerView(R.id.rvTrending, FakeData.trendingMovies)
        setupRecyclerView(R.id.rvPopularSeries, FakeData.popularSeries)
        setupRecyclerView(R.id.rvActionMovies, FakeData.actionMovies)

        // Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_home
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> true
                R.id.nav_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_favorites -> {
                    startActivity(Intent(this, FavoritesActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                else -> false
            }
        }
    }

    private fun setupRecyclerView(recyclerViewId: Int, items: List<Content>) {
        val recyclerView = findViewById<RecyclerView>(recyclerViewId)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = PosterAdapter(items) { content ->
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("EXTRA_CONTENT_ID", content.id)
            }
            startActivity(intent)
        }
    }
}

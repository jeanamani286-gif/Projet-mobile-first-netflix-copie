package com.example.streamingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : AppCompatActivity() {

    private lateinit var posterAdapter: PosterAdapter
    private lateinit var tvEmptyFavorites: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        val rvFavorites = findViewById<RecyclerView>(R.id.rvFavorites)
        tvEmptyFavorites = findViewById(R.id.tvEmptyFavorites)

        posterAdapter = PosterAdapter(emptyList()) { content ->
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("EXTRA_CONTENT_ID", content.id)
            }
            startActivity(intent)
        }

        rvFavorites.layoutManager = GridLayoutManager(this, 3)
        rvFavorites.adapter = posterAdapter

        // Bottom Navigation
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNav.selectedItemId = R.id.nav_favorites
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_search -> {
                    startActivity(Intent(this, SearchActivity::class.java))
                    overridePendingTransition(0, 0)
                    finish()
                    true
                }
                R.id.nav_favorites -> true
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

    override fun onResume() {
        super.onResume()
        loadFavorites()
    }

    private fun loadFavorites() {
        val favorites = FavoritesManager.getFavorites()
        posterAdapter.updateData(favorites)

        if (favorites.isEmpty()) {
            tvEmptyFavorites.visibility = View.VISIBLE
        } else {
            tvEmptyFavorites.visibility = View.GONE
        }
    }
}

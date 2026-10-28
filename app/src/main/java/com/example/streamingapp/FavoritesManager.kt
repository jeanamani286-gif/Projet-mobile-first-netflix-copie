package com.example.streamingapp

object FavoritesManager {
    private val favoriteIds = mutableSetOf<Int>()

    fun addFavorite(contentId: Int) {
        favoriteIds.add(contentId)
    }

    fun removeFavorite(contentId: Int) {
        favoriteIds.remove(contentId)
    }

    fun isFavorite(contentId: Int): Boolean {
        return favoriteIds.contains(contentId)
    }

    fun toggleFavorite(contentId: Int): Boolean {
        return if (isFavorite(contentId)) {
            removeFavorite(contentId)
            false
        } else {
            addFavorite(contentId)
            true
        }
    }

    fun getFavorites(): List<Content> {
        return FakeData.allContent.filter { favoriteIds.contains(it.id) }
    }
}

package com.example.streamingapp

enum class ContentType {
    MOVIE,
    SERIES
}

data class Content(
    val id: Int,
    val title: String,
    val description: String,
    val type: ContentType,
    val genre: String,
    val year: Int,
    val rating: String,
    val posterResId: Int,
    val bannerResId: Int,
    val videoUrl: String = "",
    val episodes: List<Episode> = emptyList()
)

data class Episode(
    val id: Int,
    val episodeNumber: Int,
    val title: String,
    val duration: String,
    val description: String,
    val videoUrl: String = ""
)

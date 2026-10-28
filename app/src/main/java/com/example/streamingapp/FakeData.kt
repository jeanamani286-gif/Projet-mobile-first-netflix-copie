package com.example.streamingapp

object FakeData {

    val sampleEpisodes = listOf(
        Episode(
            id = 101,
            episodeNumber = 1,
            title = "Épisode 1 : Le Début",
            duration = "45 min",
            description = "Découvrez le commencement d'une histoire captivante au rythme effréné."
        ),
        Episode(
            id = 102,
            episodeNumber = 2,
            title = "Épisode 2 : L'Affrontement",
            duration = "50 min",
            description = "Les tensions montent d'un cran entre les protagonistes."
        ),
        Episode(
            id = 103,
            episodeNumber = 3,
            title = "Épisode 3 : Le Secret",
            duration = "42 min",
            description = "Un mystère enfoui refait surface au moment le plus inattendu."
        ),
        Episode(
            id = 104,
            episodeNumber = 4,
            title = "Épisode 4 : Rébellion",
            duration = "48 min",
            description = "Rien ne sera plus jamais comme avant."
        )
    )

    val featuredContent = Content(
        id = 1,
        title = "Midas",
        description = "Un milliardaire excentrique se retrouve piégé dans un complot financier mondial. Une course contre la montre haletante.",
        type = ContentType.MOVIE,
        genre = "Action • Thriller",
        year = 2023,
        rating = "16+",
        posterResId = R.drawable.bg_card,
        bannerResId = R.drawable.bg_card,
        videoUrl = "android.resource://com.example.streamingapp/raw/sample_video"
    )

    val trendingMovies = listOf(
        featuredContent,
        Content(
            id = 2,
            title = "Thug Life",
            description = "Dans les ruelles sombres de la métropole, un gang lutte pour sa survie et son honneur.",
            type = ContentType.MOVIE,
            genre = "Drame • Crime",
            year = 2022,
            rating = "18+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card
        ),
        Content(
            id = 3,
            title = "Cyber Strike",
            description = "Dans un futur proche, des hackers s'attaquent au réseau électrique mondial.",
            type = ContentType.MOVIE,
            genre = "Sci-Fi • Action",
            year = 2024,
            rating = "13+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card
        ),
        Content(
            id = 4,
            title = "Dark Horizon",
            description = "Un vaisseau spatial perdu aux confins de la galaxie fait une découverte terrifiante.",
            type = ContentType.MOVIE,
            genre = "Horreur • Sci-Fi",
            year = 2023,
            rating = "16+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card
        )
    )

    val popularSeries = listOf(
        Content(
            id = 5,
            title = "Shadow Legacy",
            description = "Série à succès suivant le destin de deux familles rivales à travers les époques.",
            type = ContentType.SERIES,
            genre = "Série • Drame",
            year = 2023,
            rating = "16+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card,
            episodes = sampleEpisodes
        ),
        Content(
            id = 6,
            title = "Kingdom of Steel",
            description = "Épique saga médiévale où les rois et guerriers se disputent le trône de fer.",
            type = ContentType.SERIES,
            genre = "Série • Fantastique",
            year = 2021,
            rating = "16+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card,
            episodes = sampleEpisodes
        ),
        Content(
            id = 7,
            title = "Neon Nights",
            description = "Une enquête policière palpitante au cœur d'une ville cyberpunk néonisée.",
            type = ContentType.SERIES,
            genre = "Série • Enquête",
            year = 2024,
            rating = "13+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card,
            episodes = sampleEpisodes
        )
    )

    val actionMovies = listOf(
        featuredContent,
        Content(
            id = 8,
            title = "Velocity",
            description = "Des courses-poursuites infernales dans les rues de Tokyo.",
            type = ContentType.MOVIE,
            genre = "Action • Course",
            year = 2023,
            rating = "13+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card
        ),
        Content(
            id = 9,
            title = "Apex Predator",
            description = "Un commando d'élite survit dans une jungle infestée de prédateurs génétiquement modifiés.",
            type = ContentType.MOVIE,
            genre = "Action • Aventure",
            year = 2022,
            rating = "16+",
            posterResId = R.drawable.bg_card,
            bannerResId = R.drawable.bg_card
        )
    )

    val allContent = (trendingMovies + popularSeries + actionMovies).distinctBy { it.id }

    fun getContentById(id: Int): Content? {
        return allContent.find { it.id == id }
    }
}

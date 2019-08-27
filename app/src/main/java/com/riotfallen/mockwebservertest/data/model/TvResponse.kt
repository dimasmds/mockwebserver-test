package com.riotfallen.mockwebservertest.data.model

import com.squareup.moshi.Json


data class TvResponse(
    @field:Json(name = "page") var page: Int? = null,
    @field:Json(name = "total_results") var totalResults: Int? = null,
    @field:Json(name = "total_pages") var totalPages: Int? = null,
    @field:Json(name = "results") var results: List<Tv>? = emptyList()

) {
    data class Tv(
        @field:Json(name = "original_name") var originalName: String? = null,
        @field:Json(name = "genre_ids") var genreIds: List<Int>? = null,
        @field:Json(name = "name") var name: String? = null,
        @field:Json(name = "popularity") var popularity: Double? = null,
        @field:Json(name = "origin_country") var originCountry: List<String>? = null,
        @field:Json(name = "vote_count") var voteCount: Int? = null,
        @field:Json(name = "first_air_date") var firstAirDate: String? = null,
        @field:Json(name = "backdrop_path") var backdropPath: String? = null,
        @field:Json(name = "original_language") var originalLanguage: String? = null,
        @field:Json(name = "id") var id: Int? = null,
        @field:Json(name = "vote_average") var voteAverage: Double? = null,
        @field:Json(name = "overview") var overview: String? = null,
        @field:Json(name = "poster_path") var posterPath: String? = null
    )
}

data class TvDetail(
    @field:Json(name = "backdrop_path") var backdropPath: String? = null,
    @field:Json(name = "episode_run_time") var episodeRunTime: List<Int>? = null,
    @field:Json(name = "first_air_date") var firstAirDate: String? = null,
    @field:Json(name = "genres") var genres: List<Genre>? = null,
    @field:Json(name = "homepage") var homepage: String? = null,
    @field:Json(name = "id") var id: Int? = null,
    @field:Json(name = "languages") var languages: List<String>? = null,
    @field:Json(name = "last_air_date") var lastAirDate: String? = null,
    @field:Json(name = "name") var name: String? = null,
    @field:Json(name = "number_of_episodes") var numberOfEpisodes: Int? = null,
    @field:Json(name = "number_of_seasons") var numberOfSeasons: Int? = null,
    @field:Json(name = "origin_country") var originCountry: List<String>? = null,
    @field:Json(name = "original_language") var originalLanguage: String? = null,
    @field:Json(name = "original_name") var originalName: String? = null,
    @field:Json(name = "overview") var overview: String? = null,
    @field:Json(name = "popularity") var popularity: Double? = null,
    @field:Json(name = "poster_path") var posterPath: String? = null,
    @field:Json(name = "production_companies") var productionCompanies: List<ProductionCompany>? = null,
    @field:Json(name = "vote_average") var voteAverage: Double? = null,
    @field:Json(name = "vote_count") var voteCount: Int? = null
) {
    data class Genre(
        @field:Json(name = "id") val id: Int? = null,
        @field:Json(name = "name") val name: String? = null
    )

    data class ProductionCompany(
        @field:Json(name = "name") val name: String? = null
    )
}
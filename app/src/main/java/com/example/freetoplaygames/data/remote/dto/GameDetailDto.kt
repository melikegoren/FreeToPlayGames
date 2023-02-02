package com.example.freetoplaygames.data.remote.dto

import com.example.freetoplaygames.domain.model.GameDetail
import com.google.gson.annotations.SerializedName

data class GameDetailDto(
    @SerializedName("description")
    val description: String,
    @SerializedName("developer")
    val developer: String,
    @SerializedName("freetogame_profile_url")
    val freetogame_profile_url: String,
    @SerializedName("game_url")
    val game_url: String,
    @SerializedName("genre")
    val genre: String,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("minimum_system_requirements")
    val minimum_system_requirements: MinimumSystemRequirements,
    @SerializedName("platform")
    val platform: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("screenshots")
    val screenshots: List<Screenshot>,
    @SerializedName("developer")
    val short_description: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String

)
fun GameDetailDto.toGameDetail(): GameDetail {
    return GameDetail(
        id = id,
        title = title,
        thumbnail = thumbnail,
        genre = genre,
        platform = platform,
        developer = developer,
        publisher = publisher
    )

}
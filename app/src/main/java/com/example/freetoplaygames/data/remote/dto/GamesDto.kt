package com.example.freetoplaygames.data.remote.dto

import com.example.freetoplaygames.domain.model.Games
import com.google.gson.annotations.SerializedName

data class GamesDto(
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
    @SerializedName("platform")
    val platform: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("release_date")
    val release_date: String,
    @SerializedName("short_description")
    val short_description: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String
)
fun GamesDto.toGames(): Games {
    return Games(
        id = id,
        title = title,
        thumbnail = thumbnail
    )
}


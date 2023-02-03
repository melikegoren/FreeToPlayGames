package com.example.freetoplaygames.data.remote

import com.example.freetoplaygames.data.remote.dto.GameDetailDto
import com.example.freetoplaygames.data.remote.dto.GamesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FreeToPlayGamesApi {

    @GET("games")
    suspend fun getGames(): List<GamesDto>

    @GET("game")
    suspend fun getGame(@Query("id") id: String): GameDetailDto

    @GET("games")
    suspend fun getGamesInSearch(@Query("name") name: String): List<GamesDto>
}
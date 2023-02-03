package com.example.freetoplaygames.data.source

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.data.remote.dto.GamesDto
import com.example.freetoplaygames.domain.model.GameDetail
import com.example.freetoplaygames.domain.model.Games
import retrofit2.http.Query

interface RemoteDataSource {
    suspend fun getGames(): Resource<List<Games>>
    suspend fun getGameById(id: String): Resource<GameDetail>
    suspend fun getGamesInSearch(name: String): Resource<List<Games>>
}
package com.example.freetoplaygames.data.source

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.data.remote.FreeToPlayGamesApi
import com.example.freetoplaygames.data.remote.dto.GamesDto
import com.example.freetoplaygames.data.remote.dto.toGameDetail
import com.example.freetoplaygames.data.remote.dto.toGames
import com.example.freetoplaygames.domain.model.GameDetail
import com.example.freetoplaygames.domain.model.Games
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val api: FreeToPlayGamesApi
): RemoteDataSource {
    override suspend fun getGames(): Resource<List<Games>> =
        try {
            val games = api.getGames().map { it.toGames() }
            Resource.Success(games)

        }catch (e: Exception){
            Resource.Error(e.message)
        }

    override suspend fun getGameById(id: Int): Resource<GameDetail> =
        try {
            val game = api.getGame(id).toGameDetail()
            Resource.Success(game)

        }catch (e: Exception){
            Resource.Error(e.message)
        }

    override suspend fun getGamesInSearch(name: String): Resource<List<Games>> =
        try {
            val gameForSearch = api.getGamesInSearch(name).map { it.toGames() }
            Resource.Success(gameForSearch)
        } catch (e: Exception){
            Resource.Error(e.message)
        }


}
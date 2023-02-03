package com.example.freetoplaygames.data.repository

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.data.source.RemoteDataSource
import com.example.freetoplaygames.di.IoDispatcher
import com.example.freetoplaygames.domain.model.GameDetail
import com.example.freetoplaygames.domain.model.Games
import com.example.freetoplaygames.domain.repository.GamesRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    ): GamesRepository {
    override suspend fun getGames(): Resource<List<Games?>> =
        withContext(ioDispatcher){
            try {
                remoteDataSource.getGames()
            }catch (e: Exception){
                Resource.Error(e.message.toString())
            }
        }


    override suspend fun getGameById(id: String): Resource<GameDetail> =
        withContext(ioDispatcher){
            try {
                remoteDataSource.getGameById(id)
            } catch (e: Exception){
                Resource.Error(e.message.toString())
            }
        }



}

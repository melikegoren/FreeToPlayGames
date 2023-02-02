package com.example.freetoplaygames.domain.use_case.getGames

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.model.Games
import com.example.freetoplaygames.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllGamesUseCaseImpl @Inject constructor(
    private val repository: GamesRepository
): GetAllGamesUseCase {
    override fun invoke(): Flow<Resource<List<Games>>> = flow {

            emit(Resource.Loading)

            emit(repository.getGames() as Resource<List<Games>>)


    }
}
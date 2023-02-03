package com.example.freetoplaygames.domain.use_case.getGame

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.model.GameDetail
import com.example.freetoplaygames.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetGameUseCaseImpl @Inject constructor(
    private val repository: GamesRepository
): GetGameUseCase {
    override fun invoke(id: Int): Flow<Resource<GameDetail>> = flow {

        emit(Resource.Loading)
        //val game = repository.getGameById(id)
        emit(repository.getGameById(id))

    }

}
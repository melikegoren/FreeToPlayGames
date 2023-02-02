package com.example.freetoplaygames.domain.use_case.GetGamesInSearch

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.model.Games
import com.example.freetoplaygames.domain.repository.GamesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetGamesInSearchUseCaseImpl @Inject constructor(
    private val repository: GamesRepository
): GetGamesInSearchUseCase {
    override fun invoke(name: String): Flow<Resource<List<Games>>> = flow{

        emit(Resource.Loading)
        emit(repository.getGamesInSearch(name))

    }
}
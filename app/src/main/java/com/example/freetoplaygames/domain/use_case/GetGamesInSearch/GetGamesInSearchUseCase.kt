package com.example.freetoplaygames.domain.use_case.GetGamesInSearch

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface GetGamesInSearchUseCase {
    operator fun invoke(name: String): Flow<Resource<List<Games>>>
}
package com.example.freetoplaygames.domain.use_case.getGames

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface GetAllGamesUseCase {
    operator fun invoke(): Flow<Resource<List<Games>>>
}
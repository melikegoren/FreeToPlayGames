package com.example.freetoplaygames.domain.use_case.getGame

import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.model.GameDetail
import kotlinx.coroutines.flow.Flow

interface GetGameUseCase {
    operator fun invoke(id: String): Flow<Resource<GameDetail>>
}
package com.example.freetoplaygames.presentation.detail

import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.model.GameDetail
import javax.inject.Inject

class GameDetailUiMapperImpl @Inject constructor(): GameListMapper<GameDetail, GameDetailUiData> {
    override fun map(input: List<GameDetail>?): List<GameDetailUiData> {
        return input?.map {
            GameDetailUiData(
                it.title, it.thumbnail, it.genre, it.platform,
                it.developer, it.publisher
            )
        } ?: emptyList()
    }
}
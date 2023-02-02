package com.example.freetoplaygames.presentation.home

import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.model.Games
import javax.inject.Inject

class GameHomeUiMapperImpl @Inject constructor(): GameListMapper<Games, GameHomeUiData> {
    override fun map(input: List<Games>?): List<GameHomeUiData> {
        return input?.map {
            GameHomeUiData(it.title, it.thumbnail)
        } ?: emptyList()
    }
}
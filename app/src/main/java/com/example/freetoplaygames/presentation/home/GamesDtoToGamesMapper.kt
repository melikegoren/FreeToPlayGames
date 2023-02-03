package com.example.freetoplaygames.presentation.home

import com.example.freetoplaygames.data.remote.dto.GamesDto
import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.model.Games
import javax.inject.Inject

class GamesDtoToGamesMapper @Inject constructor(): GameListMapper<GamesDto, Games> {
    override fun map(input: List<GamesDto>?): List<Games> {
        return input?.map {
            Games(
                it.id, it.title, it.thumbnail
            )
        } ?: emptyList()
    }
}
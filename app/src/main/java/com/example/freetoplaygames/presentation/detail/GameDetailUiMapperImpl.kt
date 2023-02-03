package com.example.freetoplaygames.presentation.detail

import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.mapper.GameMapper
import com.example.freetoplaygames.domain.model.GameDetail
import javax.inject.Inject

class GameDetailUiMapperImpl @Inject constructor(): GameMapper<GameDetail, GameDetailUiData?> {
    override fun map(input: GameDetail?): GameDetailUiData? {
        return input?.let {
            GameDetailUiData(
                title = it.title,
                thumbnail = it.thumbnail,
                genre = it.genre,
                shortDescription = it.shortDescription,
                platform = it.platform,
                developer = it.developer,
                publisher = it.publisher
            )
        }
    }

}
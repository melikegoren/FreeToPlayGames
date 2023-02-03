package com.example.freetoplaygames.presentation.detail

import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.mapper.GameMapper
import com.example.freetoplaygames.domain.model.GameDetail
import javax.inject.Inject

class GameDetailUiMapperImpl @Inject constructor(): GameListMapper<GameDetail, GameDetailUiData>{



    override fun map(input: List<GameDetail>?): List<GameDetailUiData> {
        return input?.map {
            GameDetailUiData(
                title = it.title,
                genre = it.genre,
                shortDescription = it.shortDescription,
                platform = it.platform,
                developer = it.developer,
                publisher = it.publisher,
                thumbnail = it.thumbnail
            )
        } ?: emptyList()
    }

}
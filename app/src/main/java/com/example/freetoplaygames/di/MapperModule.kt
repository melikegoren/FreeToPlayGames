package com.example.freetoplaygames.di

import com.example.freetoplaygames.domain.mapper.GameDetailMapper
import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.model.GameDetail
import com.example.freetoplaygames.domain.model.Games
import com.example.freetoplaygames.presentation.detail.GameDetailUiData
import com.example.freetoplaygames.presentation.detail.GameDetailUiMapperImpl
import com.example.freetoplaygames.presentation.home.GameHomeUiMapperImpl
import com.example.freetoplaygames.presentation.home.GameHomeUiData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindGamesHomeUiMapper(gameHomeUiMapperImpl: GameHomeUiMapperImpl): GameListMapper<Games,GameHomeUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindGameDetailMapper(gameDetailUiMapperImpl: GameDetailUiMapperImpl): GameDetailMapper<GameDetail, GameDetailUiData>
}
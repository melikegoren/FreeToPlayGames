package com.example.freetoplaygames.di

import com.example.freetoplaygames.domain.use_case.GetGamesInSearch.GetGamesInSearchUseCase
import com.example.freetoplaygames.domain.use_case.GetGamesInSearch.GetGamesInSearchUseCaseImpl
import com.example.freetoplaygames.domain.use_case.getGames.GetAllGamesUseCase
import com.example.freetoplaygames.domain.use_case.getGames.GetAllGamesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    @ViewModelScoped
    abstract fun bindGetGamesUseCase(getAllGamesUseCaseImpl: GetAllGamesUseCaseImpl): GetAllGamesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetGamesInSearch(getGamesInSearchUseCaseImpl: GetGamesInSearchUseCaseImpl): GetGamesInSearchUseCase
}
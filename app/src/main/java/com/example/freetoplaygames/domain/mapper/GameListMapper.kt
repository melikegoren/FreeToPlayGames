package com.example.freetoplaygames.domain.mapper

import com.example.freetoplaygames.presentation.detail.GameDetailUiData

interface GameListMapper<I, O> : GameMapper<List<I>, List<O>>

interface GameDetailMapper<I,O>: GameMapper<I,O>

interface GameMapper<I, O> {
    fun map(input: I): O
}
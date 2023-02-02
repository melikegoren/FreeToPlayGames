package com.example.freetoplaygames.domain.mapper

interface GameListMapper<I, O> : GameMapper<List<I>, List<O>>

interface GameMapper<I, O> {
    fun map(input: I?): O
}
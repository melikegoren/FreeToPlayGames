package com.example.freetoplaygames.domain

data class GameEntity(
    val id: String,
    val title: String,
    val thumbnail: String,
    val shortDescription: String,
    val genre: String,
    val platform: String,
    val developer: String,
    val publisher: String
)
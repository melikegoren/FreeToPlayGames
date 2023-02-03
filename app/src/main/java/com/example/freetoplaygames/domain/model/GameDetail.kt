package com.example.freetoplaygames.domain.model

data class GameDetail(
    val id: Int,
    val title: String,
    val thumbnail: String,
    val genre: String,
    val shortDescription: String,
    val platform: String,
    val developer: String,
    val publisher: String,
)
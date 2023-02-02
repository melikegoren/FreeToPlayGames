package com.example.freetoplaygames.presentation.home

import androidx.annotation.StringRes

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: List<GameHomeUiData>) : HomeUiState()
    data class Error(@StringRes val message: Int) : HomeUiState()
}
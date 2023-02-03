package com.example.freetoplaygames.presentation.detail

import androidx.annotation.StringRes



sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: GameDetailUiData) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()

}
package com.example.freetoplaygames.presentation.detail

import androidx.annotation.StringRes
import com.example.freetoplaygames.domain.model.GameDetail


sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val data: List<GameDetailUiData>) : DetailUiState()
    data class Error(@StringRes val message: Int) : DetailUiState()

}
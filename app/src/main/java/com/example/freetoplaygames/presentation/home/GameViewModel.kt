package com.example.freetoplaygames.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetoplaygames.R
import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.model.Games
import com.example.freetoplaygames.domain.use_case.getGames.GetAllGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    private val getAllGamesUseCase: GetAllGamesUseCase,
    private val gamesMapper:GameListMapper<Games, GameHomeUiData>
) : ViewModel() {

    private val _gamesUiState = MutableLiveData<HomeUiState>()
    val gamesUiState: LiveData<HomeUiState> get() = _gamesUiState

    init {
        getAllGames()
    }

    fun getAllGames(){
        viewModelScope.launch {
            getAllGamesUseCase().collect {
                when(it){
                    is Resource.Error -> {
                        _gamesUiState.postValue(HomeUiState.Error(R.string.error))

                    }
                    is Resource.Loading -> {
                        _gamesUiState.postValue(HomeUiState.Loading)
                    }
                    is Resource.Success -> {
                        _gamesUiState.postValue(HomeUiState.Success(gamesMapper.map(it.result!!)))
                    }

                }
            }

        }
    }

    



}
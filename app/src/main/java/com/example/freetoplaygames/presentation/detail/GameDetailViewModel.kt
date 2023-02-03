package com.example.freetoplaygames.presentation.detail

import androidx.lifecycle.*
import androidx.lifecycle.Transformations.map

import com.example.freetoplaygames.R
import com.example.freetoplaygames.common.Resource
import com.example.freetoplaygames.domain.mapper.GameDetailMapper
import com.example.freetoplaygames.domain.mapper.GameListMapper
import com.example.freetoplaygames.domain.model.GameDetail
import com.example.freetoplaygames.domain.use_case.getGame.GetGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val getGameUseCase: GetGameUseCase,
    savedStateHandle: SavedStateHandle,
    private val detailMapper: GameListMapper<GameDetail, GameDetailUiData>
): ViewModel() {

    private val _gameDetailUiState = MutableLiveData<DetailUiState>()
    val gameDetailUiState: LiveData<DetailUiState> get() = _gameDetailUiState





    fun getGameById(id: Int){
        viewModelScope.launch {
            getGameUseCase(id).collect{
                when(it){
                    is Resource.Error -> {
                        _gameDetailUiState.postValue(DetailUiState.Error(R.string.error))
                    }
                    is Resource.Loading -> {
                        _gameDetailUiState.postValue(DetailUiState.Loading)
                    }
                    is Resource.Success -> {
                         _gameDetailUiState.postValue(DetailUiState.Success(detailMapper.map(it.result)))
                    }
                }
            }
        }


    }


    companion object{
        const val PARAM_GAME_ID = "id"
    }
}
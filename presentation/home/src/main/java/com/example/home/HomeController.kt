package com.example.home

import androidx.lifecycle.*
import com.example.domain.PokemonListViewService
import com.example.model.UiState
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import kotlinx.coroutines.launch

class HomeController(
    private val pokemonListViewService: PokemonListViewService
) : ViewModel(), LifecycleObserver {

    private val _pokemonListView: MutableLiveData<PokemonListView> = MutableLiveData()
    val pokemonListView: LiveData<PokemonListView> get() = _pokemonListView

    private val _uiState: MutableLiveData<UiState> = MutableLiveData()
    val uiState: LiveData<UiState> get() = _uiState

    fun fetchData() {
        _uiState.value = UiState.Loading
        viewModelScope.launch {
            when (val result = pokemonListViewService.fetchData()) {
                is Ok -> {
                    _uiState.value = UiState.Loaded
                    _pokemonListView.postValue(result.value)
                }
                is Err -> {
                    _uiState.value = UiState.Retry
                }
            }
        }
    }
}
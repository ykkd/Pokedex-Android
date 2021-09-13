package com.example.pokedex.pokemon_detail

import androidx.lifecycle.*
import com.example.domain.PokemonDetailViewService
import com.example.model.PokemonDetailView
import com.example.model.UiState
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.mapBoth
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val id: Int,
    private val pokemonDetailViewService: PokemonDetailViewService
) : ViewModel(), LifecycleObserver {

    private val _pokemonDetailView: MutableLiveData<PokemonDetailView> = MutableLiveData()
    val pokemonDetailView: LiveData<PokemonDetailView> get() = _pokemonDetailView

    private val _uiState: MutableLiveData<UiState> = MutableLiveData()
    val uiState: LiveData<UiState> get() = _uiState

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        fetchData()
    }

    fun fetchData() = viewModelScope.launch {
        _uiState.value = UiState.Loading
        pokemonDetailViewService.fetchData(id).mapBoth(
            success = {
                _uiState.value = UiState.Loaded
                _pokemonDetailView.postValue(it)
            },
            failure = {
                // エラーのハンドリング
                _uiState.value = UiState.Retry
            }
        )
    }
}
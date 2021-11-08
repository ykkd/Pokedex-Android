package com.example.home

import androidx.lifecycle.*
import com.example.domain.PokemonListViewService
import com.example.model.UiState
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.mapBoth
import kotlinx.coroutines.launch

class HomeViewModel(
    private val pokemonListViewService: PokemonListViewService
) : ViewModel(), LifecycleObserver {

    private val _pokemonListView: MutableLiveData<PokemonListView> = MutableLiveData()
    val pokemonListView: LiveData<PokemonListView> get() = _pokemonListView

    private val _uiState: MutableLiveData<UiState> = MutableLiveData(UiState.Idle)
    val uiState: LiveData<UiState> get() = _uiState

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> get() = _isLoading

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        fetchData()
    }

    fun fetchData() = viewModelScope.launch {
        _isLoading.value = true
        pokemonListViewService.fetchData().mapBoth(
            success = {
                _isLoading.value = false
                _uiState.value = UiState.Loaded
                _pokemonListView.postValue(it)
            },
            failure = {
                // エラーのハンドリング
                _isLoading.value = false
                _uiState.value = UiState.Retry
            }
        )
    }
}
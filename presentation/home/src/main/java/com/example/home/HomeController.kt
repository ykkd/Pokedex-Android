package com.example.home

import androidx.lifecycle.*
import com.airbnb.epoxy.TypedEpoxyController
import com.example.domain.PokemonListViewService
import com.example.model.UiState
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import kotlinx.coroutines.launch

class HomeController : TypedEpoxyController<PokemonListView>() {

    override fun buildModels(data: PokemonListView) {
        data ?: return
        data.pokemons.forEach {
            // アイテムを表示する
        }
    }
}
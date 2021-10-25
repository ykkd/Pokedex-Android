package com.example.home

import androidx.lifecycle.*
import com.airbnb.epoxy.TypedEpoxyController
import com.example.domain.PokemonListViewService
import com.example.model.UiState
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import kotlinx.coroutines.launch

class HomeController(
    private val onClickItem: (PokemonListView.Pokemon) -> Unit
) : TypedEpoxyController<PokemonListView>() {

    override fun buildModels(data: PokemonListView) {
        data ?: return
        data.pokemons.forEach {
            // アイテムを表示する
            pokemonList {
                id("pokemon_list_${it.number}")
                pokemon(it)
                onClickItem { model, _, _, _ ->
                    onClickItem.invoke(model.pokemon())
                }
            }
        }
    }
}
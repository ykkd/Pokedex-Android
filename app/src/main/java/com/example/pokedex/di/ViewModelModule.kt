package com.example.pokedex.di

import com.example.home.HomeViewModel
import com.example.pokedex.pokemon_detail.PokemonDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(
            pokemonListViewService = get()
        )
    }

    viewModel { (id: Int) ->
        PokemonDetailViewModel(
            id = id,
            pokemonDetailViewService = get()
        )
    }
}
package com.example.pokedex.di

import com.example.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        HomeViewModel(
            pokemonListViewService = get()
        )
    }
}
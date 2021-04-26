package com.example.domain.di

import com.example.domain.PokemonListViewService
import com.example.domain.PokemonListViewServiceImpl
import org.koin.dsl.module

val serviceModule = module {
    single {
        PokemonListViewServiceImpl(
            pokemonListRepository = get()
        ) as PokemonListViewService
    }
}
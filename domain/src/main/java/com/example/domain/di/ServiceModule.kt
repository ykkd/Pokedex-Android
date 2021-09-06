package com.example.domain.di

import com.example.domain.PokemonDetailViewService
import com.example.domain.PokemonDetailViewServiceImpl
import com.example.domain.PokemonListViewService
import com.example.domain.PokemonListViewServiceImpl
import org.koin.dsl.module

val serviceModule = module {
    single<PokemonListViewService> {
        PokemonListViewServiceImpl(
            pokemonListViewRepository = get()
        )
    }

    single<PokemonDetailViewService> {
        PokemonDetailViewServiceImpl(
            pokemonDetailViewRepository = get()
        )
    }
}
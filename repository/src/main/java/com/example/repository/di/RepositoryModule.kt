package com.example.repository.di

import com.example.repository.PokemonListViewRepository
import com.example.repository.PokemonListViewRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        PokemonListViewRepositoryImpl(
            pokeApiClient = get()
        ) as PokemonListViewRepository
    }
}
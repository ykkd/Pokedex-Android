package com.example.repository.di

import com.example.repository.PokemonListRepository
import com.example.repository.PokemonListRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        PokemonListRepositoryImpl(
            pokeApiClient = get()
        ) as PokemonListRepository
    }
}
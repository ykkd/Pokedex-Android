package com.example.repository.di

import com.example.repository.PokemonDetailViewRepository
import com.example.repository.PokemonDetailViewRepositoryImpl
import com.example.repository.PokemonListViewRepository
import com.example.repository.PokemonListViewRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PokemonListViewRepository> {
        PokemonListViewRepositoryImpl(
            pokeApiClient = get()
        )
    }

    single<PokemonDetailViewRepository> {
        PokemonDetailViewRepositoryImpl(
            pokeApiClient = get()
        )
    }
}
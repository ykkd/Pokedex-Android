package com.example.domain

import com.example.model.PokeDexApiException
import com.example.model.PokeDexException
import com.example.repository.ApiRepository
import com.example.repository.PokemonListViewRepository
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.flatMap

interface PokemonListViewService {
    suspend fun fetchData(): Result<PokemonListView, PokeDexException>
}

internal class PokemonListViewServiceImpl(
    private val pokemonListRepository: PokemonListViewRepository
) : PokemonListViewService {

    override suspend fun fetchData(): Result<PokemonListView, PokeDexException> {
        return pokemonListRepository.fetchData()
    }
}
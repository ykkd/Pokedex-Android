package com.example.domain

import com.example.model.PokeDexException
import com.example.model.PokemonDetailView
import com.example.repository.PokemonDetailViewRepository
import com.github.michaelbull.result.Result

interface PokemonDetailViewService {
    suspend fun fetchData(id: Int): Result<PokemonDetailView, PokeDexException>
}

internal class PokemonDetailViewServiceImpl(
    private val pokemonDetailViewRepository: PokemonDetailViewRepository
) : PokemonDetailViewService {

    override suspend fun fetchData(id: Int): Result<PokemonDetailView, PokeDexException> {
        return pokemonDetailViewRepository.fetchData(id)
    }
}
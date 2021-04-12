package com.example.repository

import com.example.api.client.PokeApiClient
import com.example.model.PokeDexException
import com.example.response.PokemonListResponse
import com.github.michaelbull.result.Result

interface PokemonListRepository {
    suspend fun pokemonList(): Result<PokemonListResponse, PokeDexException>
}

internal class PokemonListRepositoryImpl(
    private val pokeApiClient: PokeApiClient
): PokemonListRepository {

    override suspend fun pokemonList(): Result<PokemonListResponse, PokeDexException> {
        return pokeApiClient.fetchPokemonList()
    }
}
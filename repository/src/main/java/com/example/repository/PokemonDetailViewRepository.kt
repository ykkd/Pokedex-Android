package com.example.repository

import com.example.api.client.PokeApiClient
import com.example.model.EmptyResponseBodyException
import com.example.model.PokeDexException
import com.example.model.PokemonDetailView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.flatMap

interface PokemonDetailViewRepository {
    suspend fun fetchData(id: Int): Result<PokemonDetailView, PokeDexException>
}

internal class PokemonDetailViewRepositoryImpl(
    private val pokeApiClient: PokeApiClient
): ApiRepository(), PokemonDetailViewRepository {

    override suspend fun fetchData(id: Int): Result<PokemonDetailView, PokeDexException> {
        return execute { pokeApiClient.fetchPokemonDetail(id) }.flatMap {
            if (it != null) {
                Ok(PokemonDetailView.transform(it))
            } else {
                // 通信成功したが中身が空だった
                Err(EmptyResponseBodyException())
            }
        }
    }
}
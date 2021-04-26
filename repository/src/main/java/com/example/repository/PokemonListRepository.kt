package com.example.repository

import android.os.AsyncTask.execute
import com.example.api.client.PokeApiClient
import com.example.model.EmptyResponseBodyException
import com.example.model.PokeDexApiException
import com.example.model.PokeDexException
import com.example.response.PokemonListResponse
import com.example.response.PokemonListView
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.flatMap

interface PokemonListViewRepository {
    suspend fun fetchData(): Result<PokemonListView, PokeDexException>
}

internal class PokemonListViewRepositoryImpl(
    private val pokeApiClient: PokeApiClient
): ApiRepository(), PokemonListViewRepository {

    override suspend fun fetchData(): Result<PokemonListView, PokeDexException> {
        return execute { pokeApiClient.fetchPokemonList() }.flatMap {
            if (it != null) {
                Ok(PokemonListView.transform(it))
            } else {
                // 通信成功したが中身が空だった
                Err(EmptyResponseBodyException())
            }
        }
    }
}
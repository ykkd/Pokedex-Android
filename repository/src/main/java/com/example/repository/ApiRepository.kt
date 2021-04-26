package com.example.repository

import com.example.api.client.PokeApiClient
import com.example.model.NetworkException
import com.example.model.PokeDexApiException
import com.example.model.PokeDexException
import com.example.model.UndefinedException
import com.example.response.PokemonListResponse
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Result
import java.net.SocketTimeoutException
import java.net.UnknownHostException

open class ApiRepository {
    suspend fun <T> execute(block: suspend () -> Result<T, PokeDexApiException>): Result<T?, PokeDexException> {
        return try {
            block.invoke()
        } catch (e: SocketTimeoutException) {
            Err(NetworkException(e)) // オフライン
        } catch (e: UnknownHostException) {
            Err(NetworkException(e)) //
        } catch (e: Exception) {
            Err(UndefinedException(e))
        }
    }
}
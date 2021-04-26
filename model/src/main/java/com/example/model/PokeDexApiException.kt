package com.example.model

import java.lang.Exception

open class PokeDexException(t: Throwable? = null) : Exception()

open class PokeDexApiException(t: Throwable? = null) : PokeDexException(t)

class PokeDexApiResponseException(errorBody: String) : PokeDexApiException()

class EmptyResponseBodyException : PokeDexException()

class NetworkException(t: Throwable) : PokeDexException(t)

class UndefinedException(t: Throwable) : PokeDexException(t)

package com.example.response

data class PokemonListView(
    val pokemons: List<Pokemon>
) {
    companion object {
        fun transform(pokemonListResponse: PokemonListResponse): PokemonListView {
            return PokemonListView(
                pokemons = pokemonListResponse.results.map {
                    Pokemon.transform(it)
                }
            )
        }
    }

    data class Pokemon(
        val name: String
    ) {
        companion object {
            fun transform(pokemon: PokemonListResponse.Pokemon): Pokemon {
                return Pokemon(
                    name = pokemon.name
                )
            }
        }
    }
}
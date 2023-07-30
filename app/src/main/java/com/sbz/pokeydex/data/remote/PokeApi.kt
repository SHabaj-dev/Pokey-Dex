package com.sbz.pokeydex.data.remote

import com.sbz.pokeydex.data.remote.responses.Pokemon
import com.sbz.pokeydex.data.remote.responses.PokemonList
import com.sbz.pokeydex.util.Constants.POKEMON_HIT_POINT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET(POKEMON_HIT_POINT)
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonList

    @GET("$POKEMON_HIT_POINT/{name}")
    suspend fun getPokemonInfo(
        @Path("name") name: String
    ): Pokemon

}
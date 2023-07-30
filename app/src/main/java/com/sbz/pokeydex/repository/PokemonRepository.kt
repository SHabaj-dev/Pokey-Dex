package com.sbz.pokeydex.repository

import com.sbz.pokeydex.data.remote.PokeApi
import com.sbz.pokeydex.data.remote.responses.Pokemon
import com.sbz.pokeydex.data.remote.responses.PokemonList
import com.sbz.pokeydex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An Error Occurred -> ${e.message}")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An Error Occurred -> ${e.message}")
        }
        return Resource.Success(response)
    }


}
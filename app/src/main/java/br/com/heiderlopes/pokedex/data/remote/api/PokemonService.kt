package br.com.heiderlopes.pokedex.data.remote.api

import br.com.heiderlopes.pokedex.domain.entity.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {

    @GET("/api/v2/pokemon/{id}")
    fun pesquisar(@Path("id") id: String) : Call<Pokemon>

}
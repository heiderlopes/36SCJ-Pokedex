package br.com.heiderlopes.pokedex.domain.repository

import br.com.heiderlopes.pokedex.domain.entity.Pokemon

interface PokemonRepository {
    fun pesquisar(
        id: String,
        onComplete: (Pokemon?) -> Unit,
        onError: (Throwable) -> Unit
    )
}
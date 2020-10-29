package br.com.heiderlopes.pokedex.data.remote.mapper

import br.com.heiderlopes.pokedex.data.remote.model.PokemonPayload
import br.com.heiderlopes.pokedex.domain.entity.Pokemon

object PokemonPayloadMapper {

    fun map(pokemons: List<PokemonPayload>) = pokemons.map { map(it) }

    fun map(pokemon: PokemonPayload) = Pokemon(
        pokemon.nome,
        pokemon.sprites.other.oficialArtWork.frontDefault
    )
}
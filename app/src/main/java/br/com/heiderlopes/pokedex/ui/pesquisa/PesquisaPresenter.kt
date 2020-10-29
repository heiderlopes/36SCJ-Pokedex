package br.com.heiderlopes.pokedex.ui.pesquisa

import br.com.heiderlopes.pokedex.data.remote.api.APIService
import br.com.heiderlopes.pokedex.data.remote.api.PokemonService
import br.com.heiderlopes.pokedex.data.repository.PokemonRepositoryImpl

class PesquisaPresenter (
    val pesquisaView: PesquisaContract.PesquisaView
) : PesquisaContract.PesquisaPresenter {


    override fun pesquisar(id: String) {

        val pokemonRepository = PokemonRepositoryImpl(APIService.instance)

        pokemonRepository.pesquisar(
            id, {
                pesquisaView.exibePokemon(it)
            }, {
                pesquisaView.exibeErro(it.message)
            }
        )
    }
}
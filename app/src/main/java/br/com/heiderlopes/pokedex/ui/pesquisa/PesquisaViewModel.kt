package br.com.heiderlopes.pokedex.ui.pesquisa

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.heiderlopes.pokedex.data.remote.api.APIService
import br.com.heiderlopes.pokedex.data.repository.PokemonRepositoryImpl
import br.com.heiderlopes.pokedex.domain.entity.Pokemon

class PesquisaViewModel : ViewModel() {

    val pokemonResponse = MutableLiveData<Pokemon>()
    val mensagemErroResponse = MutableLiveData<String>()


    fun pesquisar(id: String) {
        val respository = PokemonRepositoryImpl(APIService.instance)

        respository.pesquisar(id, {
            pokemonResponse.value = it
        }, {
            mensagemErroResponse.value = it.message
        })
    }

}
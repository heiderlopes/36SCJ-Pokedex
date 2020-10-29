package br.com.heiderlopes.pokedex.ui.pesquisa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.heiderlopes.pokedex.R
import br.com.heiderlopes.pokedex.data.remote.api.APIService
import br.com.heiderlopes.pokedex.data.remote.mapper.PokemonPayloadMapper
import br.com.heiderlopes.pokedex.data.remote.model.PokemonPayload
import br.com.heiderlopes.pokedex.data.repository.PokemonRepositoryImpl
import br.com.heiderlopes.pokedex.domain.entity.Pokemon
import br.com.heiderlopes.pokedex.domain.repository.PokemonRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.btPesquisar
import kotlinx.android.synthetic.main.activity_pesquisa.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PesquisaActivity : AppCompatActivity() {

    private lateinit var pokemonRepository: PokemonRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        pokemonRepository = PokemonRepositoryImpl(APIService.instance)

        btPesquisar.setOnClickListener {
            pokemonRepository.pesquisar(
                etPokemon.text.toString(),
                { pokemon ->
                    tvNomePokemon.text = pokemon?.nome
                    Picasso.get()
                        .load(pokemon?.urlImagem)
                        .into(ivPokemon)
                }, {
                    Toast.makeText(this@PesquisaActivity,"Pokémon não encontrado", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}
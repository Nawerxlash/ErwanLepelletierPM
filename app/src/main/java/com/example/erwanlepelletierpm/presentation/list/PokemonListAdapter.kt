package com.example.erwanlepelletierpm.presentation.list

import PokemonAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.erwanlepelletierpm.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PokemonListAdapter : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = PokemonAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pokemon_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        recyclerView = view.findViewById(R.id.genshin_recyclerview)

        recyclerView.apply  {
            layoutManager = this@PokemonListAdapter.layoutManager
            adapter = this@PokemonListAdapter.adapter
        }

        val pokemonlist : ArrayList<Pokemon> = arrayListOf<Pokemon>().apply {
            add(Pokemon("Xiao"))
            add(Pokemon("Tartaglia"))
            add(Pokemon("Diluc"))
            add(Pokemon("Eula"))
        }

        adapter.updateList(pokemonlist)
    }
}
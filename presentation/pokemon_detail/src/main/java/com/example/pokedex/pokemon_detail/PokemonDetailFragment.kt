package com.example.pokedex.pokemon_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.pokedex.pokemon_detail.databinding.FragmentPokemonDetailBinding
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PokemonDetailFragment : Fragment(R.layout.fragment_pokemon_detail) {

    private var _binding: FragmentPokemonDetailBinding? = null
    private val binding get() = _binding!!
    private val args: PokemonDetailFragmentArgs by navArgs()
    private val _viewModel: PokemonDetailViewModel by viewModel { parametersOf(args.id) }
    private val controller = PokemonDetailController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPokemonDetailBinding.bind(view).apply {
            this.lifecycleOwner = viewLifecycleOwner
        }

        lifecycle.addObserver(_viewModel)

        setController()

        observe(_viewModel)
    }

    private fun setController() {
        binding.recyclerView.setController(controller)
    }

    private fun observe(viewModel: PokemonDetailViewModel) {
        viewModel.run {
            this.pokemonDetailView.observe(viewLifecycleOwner) { pokemonDetailView ->
                controller.setData(pokemonDetailView)
            }
        }
    }
}
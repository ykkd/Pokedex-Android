package com.example.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.example.home.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val _viewModel: HomeViewModel by viewModel()
    private val controller = HomeController()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view).apply {
            viewModel = _viewModel
            this.lifecycleOwner = viewLifecycleOwner
        }
        lifecycle.addObserver(_viewModel)

        observe(_viewModel)
        setupRecyclerView()
    }

    override fun onDestroyView() {
        binding.recyclerView.clear()
        binding.recyclerView.recycledViewPool.clear()
        _binding = null
        super.onDestroyView()
    }

    private fun observe(viewModel: HomeViewModel) {
        viewModel.run {
            this.pokemonListView.observe(viewLifecycleOwner) {
                controller.setData(it)
            }
        }
    }

    private fun setupRecyclerView() {
        binding.recyclerView.setController(controller)
    }
}
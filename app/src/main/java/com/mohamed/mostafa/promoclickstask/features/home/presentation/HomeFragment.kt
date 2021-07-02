package com.mohamed.mostafa.promoclickstask.features.home.presentation

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.mohamed.mostafa.promoclickstask.databinding.FragmentHomeBinding
import com.mohamed.mostafa.promoclickstask.features.detail.presentation.DetailActivity
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.HomeModel
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.ProductModel
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.HomeAdapter
import com.mohamed.mostafa.promoclickstask.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var binding: FragmentHomeBinding
    private lateinit var homeAdapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {
        subscribeToObservers()
    }

    private fun setupHomeRecyclerView(home: HomeModel) {
        homeAdapter = HomeAdapter(home, ::onProductItemClick)
        binding.recyclerView.adapter = homeAdapter
    }

    private fun onProductItemClick(product: ProductModel) {
        Timber.d("THIS IS CALLED")
        val intent = Intent(requireActivity(), DetailActivity::class.java)
        intent.putExtra("product_id", product.id)
        startActivity(intent)
    }

    private fun subscribeToObservers() {
        viewModel.getHome()
        viewModel.home.observe(viewLifecycleOwner) { result ->
            when (result) {
                is Resource.Loading -> {
                    binding.progressBar.isVisible = true
                }
                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    setupHomeRecyclerView(result.data)
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        requireContext(),
                        result.throwable.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}
package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders

import android.content.Context
import androidx.core.view.isVisible
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.R
import com.mohamed.mostafa.promoclickstask.databinding.RowListBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.*
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.ImageSliderAdapter
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.ProductsAdapter
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.SponsorsAdapter
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.VendorsAdapter

class HomeViewHolder(
    private val binding: RowListBinding,
    private val context: Context,
    private val onProductItemClick: (ProductModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(homeModel: HomeModel, position: Int) {
        when (position) {
            0 -> {
                setupSliderAdapter(homeModel.homeDataModel?.sliderModels ?: emptyList())
            }
            1 -> {
                setupSponsors(homeModel.homeDataModel?.sponsorModels ?: emptyList())
            }
            2 -> {
                setupVendors(homeModel.homeDataModel?.vendorModel ?: emptyList())
            }
            3 -> {
                setupHotDiscounts(homeModel.homeDataModel?.hotProductPaidStatus ?: emptyList())
            }
            4 -> {
                setupHotSeller(homeModel.homeDataModel?.hotSallerPaidStatus ?: emptyList())
            }
            5 -> {
                setupRecommended(homeModel.homeDataModel?.recommendPaidStatuses ?: emptyList())
            }
        }
    }


    private fun setupSliderAdapter(images: List<SliderModel>) {
        binding.titleTextView.isVisible = false
        val adapter =
            ImageSliderAdapter(images)
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun setupSponsors(sponsors: List<SponsorModel>) {
        binding.titleTextView.text = context.getString(R.string.sponsers)
        binding.titleTextView.isVisible = true
        val adapter = SponsorsAdapter(sponsors)
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun setupVendors(vendors: List<VendorModel>) {
        binding.titleTextView.text = context.getString(R.string.vendors)
        binding.titleTextView.isVisible = true
        val adapter = VendorsAdapter(vendors)
        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun setupHotDiscounts(products: List<ProductModel>) {
        binding.titleTextView.text = context.getString(R.string.hot_discounts)
        binding.titleTextView.isVisible = true
        val adapter = ProductsAdapter(products, onProductItemClick)
        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun setupHotSeller(products: List<ProductModel>) {
        binding.titleTextView.text = context.getString(R.string.hot_seller)
        binding.titleTextView.isVisible = true
        val adapter = ProductsAdapter(products, onProductItemClick)
        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }

    private fun setupRecommended(products: List<ProductModel>) {
        binding.titleTextView.text = context.getString(R.string.recommeneded)
        binding.titleTextView.isVisible = true
        val adapter = ProductsAdapter(products, onProductItemClick)
        val layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = adapter
    }
}
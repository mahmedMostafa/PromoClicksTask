package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamed.mostafa.promoclickstask.databinding.RowProductBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.ProductModel

class ProductViewHolder(
    private val binding: RowProductBinding,
    private val context: Context,
    private val onProductItemClick: (ProductModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {


    fun onBind(product: ProductModel) {
        binding.root.setOnClickListener { onProductItemClick.invoke(product) }
        Glide.with(context).load(product.image).into(binding.productImageView)
        binding.productTitleTextView.text = product.name ?: ""
        binding.productDurationTextView.text = product.expDate ?: ""
        binding.oldPriceTextView.text = product.oldPrice.toString()
        binding.newPriceTextView.text = product.newPrice.toString()
    }
}
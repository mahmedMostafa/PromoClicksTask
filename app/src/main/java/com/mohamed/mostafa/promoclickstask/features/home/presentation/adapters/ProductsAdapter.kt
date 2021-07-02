package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowProductBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.ProductModel
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders.ProductViewHolder

class ProductsAdapter(
    private val products: List<ProductModel>,
    private val onProductItemClick: (ProductModel) -> Unit,
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = RowProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(view, parent.context, onProductItemClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.onBind(products[position])
    }

    override fun getItemCount() = products.size

}
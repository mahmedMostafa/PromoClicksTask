package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowListBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.HomeModel
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.ProductModel
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders.HomeViewHolder

class HomeAdapter(
    private val homeModel: HomeModel,
    private val onProductItemClick: (ProductModel) -> Unit,
) : RecyclerView.Adapter<HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = RowListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(view, parent.context, onProductItemClick)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.onBind(homeModel, position)
    }

    override fun getItemCount() = 6
}
package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowSliderBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.SliderModel
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders.ImageSliderViewHolder

class ImageSliderAdapter(
    private val images: List<SliderModel>,
) : RecyclerView.Adapter<ImageSliderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderViewHolder {
        val view = RowSliderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageSliderViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: ImageSliderViewHolder, position: Int) {
        holder.onBind(images[position].image ?: "")
    }

    override fun getItemCount() = images.size
}
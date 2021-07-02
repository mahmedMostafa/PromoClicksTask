package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamed.mostafa.promoclickstask.databinding.RowSliderBinding

class ImageSliderViewHolder(
    private val binding: RowSliderBinding,
    private val context: Context
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(image: String) {
        Glide.with(context).load(image).into(binding.sliderImageView)
    }
}
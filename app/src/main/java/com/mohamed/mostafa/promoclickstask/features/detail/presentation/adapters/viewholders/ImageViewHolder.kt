package com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters.viewholders

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamed.mostafa.promoclickstask.R
import com.mohamed.mostafa.promoclickstask.databinding.RowImageBinding
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.GallaryModel

class ImageViewHolder(
    private val binding: RowImageBinding,
    private val context: Context,
    private val onImageClick: (GallaryModel) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(image: GallaryModel, selectedPosition: Int) {
        binding.root.setOnClickListener { onImageClick.invoke(image) }
        Glide.with(context).load(image.images).into(binding.imageView)

        if (selectedPosition == adapterPosition) {
            binding.root.background =
                ContextCompat.getDrawable(context, R.drawable.bg_rounded_purple_border)
        } else {
            binding.root.background =
                ContextCompat.getDrawable(context, R.drawable.bg_rounded_white)
        }
    }
}
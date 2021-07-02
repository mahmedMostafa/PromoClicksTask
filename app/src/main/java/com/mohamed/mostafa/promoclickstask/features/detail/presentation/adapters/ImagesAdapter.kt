package com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowImageBinding
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.GallaryModel
import com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters.viewholders.ImageViewHolder

class ImagesAdapter(
    private val images: List<GallaryModel>,
    private val onImageClick: (GallaryModel) -> Unit
) : RecyclerView.Adapter<ImageViewHolder>() {

    private var selectedImageIndex = 0

    fun setSelectedImage(image: GallaryModel) {
        images.forEachIndexed { index, currentImage ->
            if (currentImage.id == image.id) {
                selectedImageIndex = index
                notifyDataSetChanged()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = RowImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(view, parent.context, onImageClick)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(images[position], selectedImageIndex)
    }

    override fun getItemCount() = images.size
}
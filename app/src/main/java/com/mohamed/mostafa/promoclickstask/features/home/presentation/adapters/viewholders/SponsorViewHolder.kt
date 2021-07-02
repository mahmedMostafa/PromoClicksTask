package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamed.mostafa.promoclickstask.databinding.RowSponsorBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.SponsorModel

class SponsorViewHolder(
    private val binding: RowSponsorBinding,
    private val context: Context,
) : RecyclerView.ViewHolder(binding.root) {


    fun onBind(sponsor: SponsorModel) {
        Glide.with(context).load(sponsor.image).into(binding.roundedImageView)
    }
}
package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamed.mostafa.promoclickstask.databinding.RowVendorBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.VendorModel

class VendorViewHolder(
    private val binding: RowVendorBinding,
    private val context: Context,
) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(vendor: VendorModel) {
        Glide.with(context).load(vendor).into(binding.vendorImageView)
        binding.vendorTitleTextView.text = vendor.name ?: ""
    }
}
package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowVendorBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.VendorModel
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders.VendorViewHolder

class VendorsAdapter(
    private val vendors: List<VendorModel>
) : RecyclerView.Adapter<VendorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorViewHolder {
        val view = RowVendorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VendorViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        holder.onBind(vendors[position])
    }

    override fun getItemCount() = vendors.size
}
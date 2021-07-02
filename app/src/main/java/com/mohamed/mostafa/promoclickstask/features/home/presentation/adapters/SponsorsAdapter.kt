package com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowSponsorBinding
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.SponsorModel
import com.mohamed.mostafa.promoclickstask.features.home.presentation.adapters.viewholders.SponsorViewHolder

class SponsorsAdapter(
    private val sponsors: List<SponsorModel>
) : RecyclerView.Adapter<SponsorViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsorViewHolder {
        val view = RowSponsorBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SponsorViewHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: SponsorViewHolder, position: Int) {
        holder.onBind(sponsors[position])
    }

    override fun getItemCount() = sponsors.size

}
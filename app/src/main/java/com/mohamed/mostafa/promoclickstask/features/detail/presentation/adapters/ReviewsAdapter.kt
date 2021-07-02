package com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowReviewBinding
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ReviewModel
import com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters.viewholders.ReviewViewHolder

class ReviewsAdapter(
    private val reviews: List<ReviewModel>
) : RecyclerView.Adapter<ReviewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val view = RowReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReviewViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.onBind(reviews[position])
    }

    override fun getItemCount() = reviews.size
}
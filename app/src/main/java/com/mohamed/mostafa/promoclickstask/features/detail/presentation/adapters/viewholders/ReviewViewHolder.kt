package com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.mohamed.mostafa.promoclickstask.databinding.RowReviewBinding
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ReviewModel

class ReviewViewHolder(
    private val binding: RowReviewBinding,
) : RecyclerView.ViewHolder(binding.root) {


    fun onBind(review: ReviewModel) {
        binding.reviewRatingBar.rating = review.rate?.toFloat() ?: 0f
        binding.nameTextView.text = "Mohamed Salama" //there should be a name in the API
        binding.commentTextView.text = review.comment ?: ""
    }
}
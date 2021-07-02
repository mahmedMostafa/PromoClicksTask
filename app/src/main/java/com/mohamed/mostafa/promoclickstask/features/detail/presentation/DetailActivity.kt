package com.mohamed.mostafa.promoclickstask.features.detail.presentation

import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.mohamed.mostafa.promoclickstask.R
import com.mohamed.mostafa.promoclickstask.databinding.ActivityDetailBinding
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.GallaryModel
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ProductDetailsData
import com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters.ImagesAdapter
import com.mohamed.mostafa.promoclickstask.features.detail.presentation.adapters.ReviewsAdapter
import com.mohamed.mostafa.promoclickstask.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel by viewModels<DetailsViewModel>()

    private lateinit var binding: ActivityDetailBinding
    private lateinit var imagesAdapter: ImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        subscribeToObservers()
    }

    private fun subscribeToObservers() {
        viewModel.getProductDetails(intent.getIntExtra("product_id", 1))
        viewModel.productDetails.observe(this) { resource ->
            when (resource) {
                is Resource.Loading -> {

                }
                is Resource.Success -> {
                    binding.progressBar.isVisible = false
                    binding.view.isVisible = true
                    bindViews(resource.data.data)
                }
                is Resource.Error -> {
                    binding.progressBar.isVisible = false
                    Toast.makeText(
                        this,
                        resource.throwable.message.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun bindViews(data: ProductDetailsData?) {
        //Images
        Glide.with(this).load(data?.productModel?.galleries?.first()?.images)
            .into(binding.selectedImageView)
        imagesAdapter =
            ImagesAdapter(data?.productModel?.galleries ?: emptyList(), ::onImageClick)
        binding.imagesRecyclerView.adapter = imagesAdapter

        //Price Info
        binding.oldPriceTextView.text =
            getString(R.string.price, data?.productModel?.oldPrice.toString())
        binding.oldPriceTextView.paintFlags =
            binding.oldPriceTextView.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        binding.newPriceTextView.text =
            getString(R.string.price, data?.productModel?.newPrice.toString())

        //Product Info
        binding.durationTextView.text = data?.productModel?.expDate ?: ""
        binding.viewsTextView.text = data?.productModel?.productUserNumber.toString()
        binding.descriptionTextView.text = data?.productModel?.description ?: ""

        //Reviews
        val reviewsAdapter = ReviewsAdapter(data?.productModel?.reviews ?: emptyList())
        binding.reviewsRecyclerView.adapter = reviewsAdapter

        //Contact Info
        binding.phoneNumberTextView.text = data?.productModel?.mobile ?: ""
        binding.emailTextView.text = data?.productModel?.email ?: ""
        binding.placeTextView.text = data?.productModel?.address ?: ""
        val mapUrl =
            "https://maps.googleapis.com/maps/api/staticmap?center=${data?.productModel?.lng},${data?.productModel?.lat}&zoom=18&size=600x300&markers=color:red%7${
                getString(R.string.location)
            }label:C%7C${data?.productModel?.lng},${data?.productModel?.lat}&key=${
                getString(
                    R.string.google_maps_api_key
                )
            }"
        Glide.with(this).asBitmap().skipMemoryCache(true).load(Uri.parse(Uri.decode(mapUrl)))
            .into(binding.mapImageView)
    }

    private fun onImageClick(image: GallaryModel) {
        Glide.with(this).load(image.images).into(binding.selectedImageView)
        imagesAdapter.setSelectedImage(image)
    }
}
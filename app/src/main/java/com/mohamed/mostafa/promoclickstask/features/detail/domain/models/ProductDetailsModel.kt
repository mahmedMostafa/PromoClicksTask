package com.mohamed.mostafa.promoclickstask.features.detail.domain.models
import com.squareup.moshi.Json



data class ProductDetailsModel(
    @Json(name = "data")
    val `data`: ProductDetailsData?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "success")
    val success: Boolean?
)

data class ProductDetailsData(
    @Json(name = "Products")
    val productModel: ProductModel?
)

data class ProductModel(
    @Json(name = "address")
    val address: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "exp_date")
    val expDate: String?,
    @Json(name = "Gallary")
    val galleries: List<GallaryModel>?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "lat")
    val lat: String?,
    @Json(name = "lng")
    val lng: String?,
    @Json(name = "mobile")
    val mobile: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "new_price")
    val newPrice: Int?,
    @Json(name = "old_price")
    val oldPrice: Int?,
    @Json(name = "ProductUserNumber")
    val productUserNumber: Int?,
    @Json(name = "rate")
    val rate: Int?,
    @Json(name = "review")
    val reviews: List<ReviewModel>?,
    @Json(name = "vendor")
    val vendor: String?
)

data class GallaryModel(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "images")
    val images: String?
)

data class ReviewModel(
    @Json(name = "comment")
    val comment: String?,
    @Json(name = "rate")
    val rate: String?
)
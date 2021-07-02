package com.mohamed.mostafa.promoclickstask.features.home.domain.models
import com.squareup.moshi.Json



data class HomeModel(
    @Json(name = "data")
    val homeDataModel: HomeDataModel?,
    @Json(name = "message")
    val message: String?,
    @Json(name = "success")
    val success: Boolean?
)

data class HomeDataModel(
    @Json(name = "hot_product_paid_status")
    val hotProductPaidStatus: List<ProductModel>?,
    @Json(name = "hot_saller_paid_status")
    val hotSallerPaidStatus: List<ProductModel>?,
    @Json(name = "recommend_paid_status")
    val recommendPaidStatuses: List<ProductModel>?,
    @Json(name = "Sliders")
    val sliderModels: List<SliderModel>?,
    @Json(name = "Sponsors")
    val sponsorModels: List<SponsorModel>?,
    @Json(name = "vendor")
    val vendorModel: List<VendorModel>?
)

data class ProductModel(
    @Json(name = "exp_date")
    val expDate: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "new_price")
    val newPrice: Int?,
    @Json(name = "old_price")
    val oldPrice: Int?,
    @Json(name = "ProductUserNumber")
    val productUserNumber: Int?,
    @Json(name = "rate")
    val rate: Int?
)

data class SliderModel(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "product")
    val product: Int?,
    @Json(name = "title")
    val title: String?
)

data class SponsorModel(
    @Json(name = "image")
    val image: String?
)

data class VendorModel(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "image")
    val image: String?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "sub_id")
    val subId: String?
)
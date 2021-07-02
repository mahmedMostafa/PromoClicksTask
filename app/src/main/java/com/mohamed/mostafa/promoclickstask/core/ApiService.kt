package com.mohamed.mostafa.promoclickstask.core

import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ProductDetailsModel
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.HomeModel
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @GET("home-page")
    suspend fun getHome(): HomeModel

    @POST("product-detalis")
    @FormUrlEncoded
    suspend fun getProductDetails(
        @Field(value = "product_id") productId: Int
    ): ProductDetailsModel
}
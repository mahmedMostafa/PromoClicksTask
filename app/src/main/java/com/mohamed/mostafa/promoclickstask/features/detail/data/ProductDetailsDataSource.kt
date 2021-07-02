package com.mohamed.mostafa.promoclickstask.features.detail.data

import com.mohamed.mostafa.promoclickstask.core.ApiService
import javax.inject.Inject

class ProductDetailsDataSource @Inject constructor(
    private val apiService: ApiService,
) {


    suspend fun getProductDetails(id: Int) = apiService.getProductDetails(id)
}
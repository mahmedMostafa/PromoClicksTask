package com.mohamed.mostafa.promoclickstask.features.home.data

import com.mohamed.mostafa.promoclickstask.core.ApiService
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.HomeModel
import com.mohamed.mostafa.promoclickstask.utils.Resource
import javax.inject.Inject

class HomeDataSource @Inject constructor(
    private val apiService: ApiService,
) {
    suspend fun getHome(): HomeModel = apiService.getHome()
}
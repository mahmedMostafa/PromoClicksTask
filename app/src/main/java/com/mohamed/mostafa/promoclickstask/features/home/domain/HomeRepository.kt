package com.mohamed.mostafa.promoclickstask.features.home.domain

import com.mohamed.mostafa.promoclickstask.features.home.data.HomeDataSource
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.HomeModel
import com.mohamed.mostafa.promoclickstask.utils.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val homeDataSource: HomeDataSource
) {

    suspend fun getHome(): Resource<HomeModel> = withContext(IO) {
        return@withContext try {
            val result = homeDataSource.getHome()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
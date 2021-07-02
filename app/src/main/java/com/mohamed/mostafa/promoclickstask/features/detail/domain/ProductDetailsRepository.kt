package com.mohamed.mostafa.promoclickstask.features.detail.domain

import com.mohamed.mostafa.promoclickstask.features.detail.data.ProductDetailsDataSource
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ProductDetailsData
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ProductDetailsModel
import com.mohamed.mostafa.promoclickstask.utils.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

class ProductDetailsRepository @Inject constructor(
    private val productDetailsDataSource: ProductDetailsDataSource,
) {


    suspend fun getProductDetails(id: Int): Resource<ProductDetailsModel> = withContext(IO) {
        return@withContext try {
            val result = productDetailsDataSource.getProductDetails(id)
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e)
        }
    }
}
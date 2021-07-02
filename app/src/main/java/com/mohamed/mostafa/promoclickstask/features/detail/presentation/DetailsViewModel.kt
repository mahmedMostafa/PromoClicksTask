package com.mohamed.mostafa.promoclickstask.features.detail.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.promoclickstask.features.detail.domain.ProductDetailsRepository
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ProductDetailsData
import com.mohamed.mostafa.promoclickstask.features.detail.domain.models.ProductDetailsModel
import com.mohamed.mostafa.promoclickstask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: ProductDetailsRepository
) : ViewModel() {

    private val _productDetails = MutableLiveData<Resource<ProductDetailsModel>>()
    val productDetails: LiveData<Resource<ProductDetailsModel>> get() = _productDetails


    fun getProductDetails(id: Int) = viewModelScope.launch {
        _productDetails.value = repository.getProductDetails(id)
    }

}
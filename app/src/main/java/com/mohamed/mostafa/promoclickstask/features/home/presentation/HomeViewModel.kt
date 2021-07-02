package com.mohamed.mostafa.promoclickstask.features.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamed.mostafa.promoclickstask.features.home.domain.HomeRepository
import com.mohamed.mostafa.promoclickstask.features.home.domain.models.HomeModel
import com.mohamed.mostafa.promoclickstask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    private val _home = MutableLiveData<Resource<HomeModel>>()
    val home: LiveData<Resource<HomeModel>> get() = _home

    fun getHome() = viewModelScope.launch {
        _home.value = Resource.Loading
        _home.value = repository.getHome()
    }
}
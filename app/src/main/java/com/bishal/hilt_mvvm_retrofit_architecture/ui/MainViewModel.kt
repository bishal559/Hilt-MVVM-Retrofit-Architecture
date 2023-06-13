package com.bishal.hilt_mvvm_retrofit_architecture.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bishal.hilt_mvvm_retrofit_architecture.ui.module.Flower
import com.bishal.hilt_mvvm_retrofit_architecture.ui.repository.MainRepository
import com.bishal.hilt_mvvm_retrofit_architecture.utils.NetworkHelper
import com.bishal.hilt_mvvm_retrofit_architecture.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    private val _flowers = MutableLiveData<Resource<List<Flower>>>()
    val flowers: LiveData<Resource<List<Flower>>>
        get() = _flowers

    init {
        fetchFlowers()
    }

    private fun fetchFlowers() {
        viewModelScope.launch {
            _flowers.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getFlowers().let {
                    if (it.isSuccessful) {
                        _flowers.postValue(Resource.success(it.body()))
                    } else _flowers.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _flowers.postValue(Resource.error("No internet connection", null))
        }
    }
}
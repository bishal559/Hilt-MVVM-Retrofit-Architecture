package com.bishal.hilt_mvvm_retrofit_architecture.ui.repository

import com.bishal.hilt_mvvm_retrofit_architecture.network.ApiServices
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiServices) {


    suspend fun getFlowers() =  apiHelper.getFlowers()

}
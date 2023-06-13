package com.bishal.hilt_mvvm_retrofit_architecture.network

import com.bishal.hilt_mvvm_retrofit_architecture.network.API_URL.GETFLOWERS
import com.bishal.hilt_mvvm_retrofit_architecture.ui.module.Flower
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {
    @GET(GETFLOWERS)
    suspend fun getFlowers(): Response<List<Flower>>
}
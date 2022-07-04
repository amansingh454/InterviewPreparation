package com.example.interviewpreparation.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        fun getRetrofitInstance(): ApiService {
            val retrofit = Retrofit.Builder().baseUrl(ApiConstants.GITHUB_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
            return retrofit.build().create(ApiService::class.java)
        }
    }
}












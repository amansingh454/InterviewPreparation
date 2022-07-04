package com.example.interviewpreparation.data.network

import com.example.interviewpreparation.data.models.ClosedMr
import retrofit2.http.GET


interface ApiService {

    //https://api.github.com/repos/vmg/redcarpet/pulls?state=closed

    @GET(ApiConstants.GITHUB_CLOSED_MR)
    suspend fun getPullRequest(): List<ClosedMr>

}



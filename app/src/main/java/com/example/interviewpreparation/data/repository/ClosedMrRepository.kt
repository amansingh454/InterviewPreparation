package com.example.interviewpreparation.data.repository

import android.util.Log
import com.example.interviewpreparation.data.models.UserData
import com.example.interviewpreparation.data.network.ApiService
import com.example.interviewpreparation.domain.model.ClosedMr
import com.example.interviewpreparation.domain.repository.IClosedMrRepository

class ClosedMrRepository(private val apiService: ApiService) : IClosedMrRepository {

    companion object {
        private val TAG = ClosedMrRepository::class.java.simpleName
    }

    override suspend fun fetchPullRequests(): List<ClosedMr> {
        val data = apiService.getPullRequest()
        Log.d(TAG,"data from network $data")
        return if (data.isNotEmpty()) {
            data.map {
                it.toDomainClosedMr()
            }
        } else {
            emptyList()
        }

    }

    private fun com.example.interviewpreparation.data.models.ClosedMr.toDomainClosedMr(): ClosedMr {
        return ClosedMr(
            title = mrTitle,
            createdDate = createdAt,
            closedDate = closedAt,
            userData = userData.toDomainUserData()

        )
    }

    private fun UserData.toDomainUserData(): com.example.interviewpreparation.domain.model.UserData {
        return com.example.interviewpreparation.domain.model.UserData(
            userName = userName,
            userImage = userImage
        )
    }


}
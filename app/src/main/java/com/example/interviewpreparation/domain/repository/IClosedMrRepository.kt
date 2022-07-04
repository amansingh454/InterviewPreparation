package com.example.interviewpreparation.domain.repository

import com.example.interviewpreparation.domain.model.ClosedMr

interface IClosedMrRepository {

    suspend fun fetchPullRequests():List<ClosedMr>
}
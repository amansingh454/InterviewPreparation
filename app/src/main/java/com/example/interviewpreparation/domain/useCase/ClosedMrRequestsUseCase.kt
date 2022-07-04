package com.example.interviewpreparation.domain.useCase

import com.example.interviewpreparation.Utils.Resource
import com.example.interviewpreparation.domain.model.ClosedMr
import com.example.interviewpreparation.domain.repository.IClosedMrRepository
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

import retrofit2.HttpException


class ClosedMrRequestsUseCase(private val iClosedMrRepository: IClosedMrRepository) {

     operator fun invoke(): Flow<Resource<List<ClosedMr>>> = flow {
        emit(Resource.Loading())
        try {
            val data = iClosedMrRepository.fetchPullRequests()
            emit(Resource.Success(data))
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Unknown Issue"))

        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Please Check Connection"))
        }
    }
}
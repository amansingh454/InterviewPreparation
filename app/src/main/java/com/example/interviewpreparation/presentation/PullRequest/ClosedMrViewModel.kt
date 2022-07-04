package com.example.interviewpreparation.presentation.PullRequest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.interviewpreparation.Utils.Resource
import com.example.interviewpreparation.domain.model.Result
import com.example.interviewpreparation.domain.useCase.ClosedMrRequestsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ClosedMrViewModel(private val closedMrRequestUseCase: ClosedMrRequestsUseCase) :
    ViewModel() {
    companion object {
        private val TAG = ClosedMrViewModel::class.java.simpleName
    }

    private val mPullRequestData: MutableLiveData<Result> = MutableLiveData()
    val pullRequestData: MutableLiveData<Result> = mPullRequestData

    fun getData() {
        mPullRequestData.postValue(Result(isLoading = true))
        closedMrRequestUseCase().onEach {
            when (it) {
                is Resource.Success -> mPullRequestData.postValue(Result(it.data))
                is Resource.Error -> mPullRequestData.postValue(Result(isError = it.message))
                is Resource.Loading -> mPullRequestData.postValue(Result(isLoading = true))
            }
        }.launchIn(viewModelScope)
    }
}



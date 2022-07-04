package com.example.interviewpreparation.di

import com.example.interviewpreparation.domain.useCase.ClosedMrRequestsUseCase
import com.example.interviewpreparation.presentation.PullRequest.ClosedMrViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ClosedMrViewModel(get())
    }
    single { ClosedMrRequestsUseCase(get()) }
}

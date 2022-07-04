package com.example.interviewpreparation.di

import com.example.interviewpreparation.data.network.RetrofitInstance
import com.example.interviewpreparation.data.repository.ClosedMrRepository
import com.example.interviewpreparation.domain.repository.IClosedMrRepository
import org.koin.dsl.module

val repositoryModule = module {

    single { RetrofitInstance.getRetrofitInstance() }
    single<IClosedMrRepository> {
        ClosedMrRepository(get())
    }

}
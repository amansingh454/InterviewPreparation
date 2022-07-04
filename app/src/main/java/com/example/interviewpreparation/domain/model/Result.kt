package com.example.interviewpreparation.domain.model


data class Result(
    val data: List<ClosedMr>? = null,
    val isError: String? = "",
    val isLoading: Boolean = false
)

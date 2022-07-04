package com.example.interviewpreparation.domain.model


data class ClosedMr(
    val title: String?,
    val createdDate: String?,
    val closedDate: String?,
    val userData: UserData
)

data class UserData(
    val userName: String?,
    val userImage: String?
)






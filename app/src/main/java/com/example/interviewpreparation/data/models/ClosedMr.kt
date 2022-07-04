package com.example.interviewpreparation.data.models

import com.google.gson.annotations.SerializedName

data class ClosedMr(
    @SerializedName("title")
    val mrTitle: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("closed_at")
    val closedAt: String?,
    @SerializedName("user")
    val userData: UserData
)

/**
 * userName, user Image
 */
data class UserData(
    @SerializedName("login")
    val userName: String?,
    @SerializedName("avatar_url")
    val userImage: String?
)

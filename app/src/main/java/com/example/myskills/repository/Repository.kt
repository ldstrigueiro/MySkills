package com.example.myskills.repository

import com.example.myskills.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface Repository {
    @Headers("Accept: application/json")
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}
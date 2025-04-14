package com.example.samplejetpackcompose.data.network

import com.example.samplejetpackcompose.data.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}
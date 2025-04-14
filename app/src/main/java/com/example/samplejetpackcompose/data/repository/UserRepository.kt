package com.example.samplejetpackcompose.data.repository

import com.example.samplejetpackcompose.data.User
import com.example.samplejetpackcompose.data.network.ApiService
import javax.inject.Inject


class UserRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getUser(): List<User> = apiService.getUsers()
}
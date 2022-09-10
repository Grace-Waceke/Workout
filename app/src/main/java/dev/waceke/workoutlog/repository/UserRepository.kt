package dev.waceke.workoutlog.repository

import dev.waceke.workoutlog.api.ApiClient
import dev.waceke.workoutlog.api.ApiInterface
import dev.waceke.workoutlog.models.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    val apiClient=ApiClient.buildApiClient((ApiInterface::class.java))

    suspend fun login(loginRequest: LoginRequest)= withContext(Dispatchers.IO){
        val response=apiClient.login(loginRequest)
        return@withContext response
    }
}
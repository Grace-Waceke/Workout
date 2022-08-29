package dev.waceke.workoutlog.retrofit

import dev.waceke.workoutlog.models.RegisterRequest
import dev.waceke.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>
}
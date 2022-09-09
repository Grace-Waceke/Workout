package dev.waceke.workoutlog.retrofit

import dev.waceke.workoutlog.models.LoginRequest
import dev.waceke.workoutlog.models.LoginResponse
import dev.waceke.workoutlog.models.RegisterRequest
import dev.waceke.workoutlog.models.RegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Call<RegisterResponse>

    @POST("/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}
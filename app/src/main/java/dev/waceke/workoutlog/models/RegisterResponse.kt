package dev.waceke.workoutlog.models

import android.os.Message

data class RegisterResponse(
    var message: String,
    var user: User
)

package dev.waceke.workoutlog.models

import android.provider.ContactsContract

data class LoginRequest(
    var email: String,
    var password: String,
)

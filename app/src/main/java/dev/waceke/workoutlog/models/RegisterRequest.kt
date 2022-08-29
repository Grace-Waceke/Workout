package dev.waceke.workoutlog.models

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("First_Name") var  FirstName: String,
    @SerializedName("LastName") var  LastName: String,
   var  email: String,
  var  password: String,
    @SerializedName("phoneNumber") var  phoneNumber: String,






)

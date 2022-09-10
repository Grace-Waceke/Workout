package dev.waceke.workoutlog.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.waceke.workoutlog.models.LoginRequest
import dev.waceke.workoutlog.models.LoginResponse
import dev.waceke.workoutlog.repository.UserRepository
import kotlinx.coroutines.launch
import kotlin.math.log

class UserViewModel:ViewModel() {
    val userRepository= UserRepository()
    var loginResponseLiveData=MutableLiveData<LoginResponse>()
    val loginErrorLiveData=MutableLiveData<String>()
//livedata is an observable data and a repository acts as a data source
    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response=userRepository.login(loginRequest)
            if (response.isSuccessful){
               loginResponseLiveData.postValue((response.body()))
            }
            else{
                val error=response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }

    }    }
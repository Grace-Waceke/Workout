package dev.waceke.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.waceke.workoutlog.databinding.ActivityLogInBinding
import dev.waceke.workoutlog.models.LoginRequest
import dev.waceke.workoutlog.models.LoginResponse

import dev.waceke.workoutlog.api.ApiClient
import dev.waceke.workoutlog.api.ApiInterface
import dev.waceke.workoutlog.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs=getSharedPreferences("WORKOUTLOG_PREFS", MODE_PRIVATE)



        binding.btnLogIn.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            validateLogIn()
        }
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
 override fun onResume() {
     super.onResume()
     userViewModel.loginResponseLiveData.observe(this, Observer { loginResponse ->
         Toast.makeText(baseContext, loginResponse?.message, Toast.LENGTH_LONG).show()
         saveLoginDetails(loginResponse!!)
         startActivity(Intent(baseContext, HomeActivity::class.java))
         finish()
     })
    userViewModel.loginErrorLiveData.observe(this, Observer{ error->
        Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
    })
 }
    fun validateLogIn() {
        var error=false
        binding.tilEmail.error=null
        binding.tilPassword.error=null
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()

        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (!error) {
            val loginRequest = LoginRequest(email, password)
            binding.pbLogin.visibility=View.GONE
            userViewModel.loginUser(loginRequest)
//            makeLoginRequest(loginRequest)
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
//    fun makeLoginRequest(loginRequest: LoginRequest) {
//        val apiClient = ApiClient.buildApiClient((ApiInterface::class.java))
//        val request = apiClient.login(loginRequest)
//        request.enqueue(object : Callback<LoginResponse> {
//            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
//               binding.pbLogin.visibility=View.GONE
//                if (response.isSuccessful){
//                    var loginResponse=response.body()
//                }
//                else{
//                val error = response.errorBody()?.string()
//                Toast.makeText(baseContext, error,Toast.LENGTH_LONG).show()
//            }
//        }
//            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//            }
//        })
//        }
    fun saveLoginDetails(loginResponse: LoginResponse){
        val editor=sharedPrefs.edit()
        editor.putString("access_token",loginResponse.accessToken)
        editor.putString("user_id",loginResponse.accessToken)
        editor.putString("profile_id",loginResponse.accessToken)
        editor.apply()
    }
    }


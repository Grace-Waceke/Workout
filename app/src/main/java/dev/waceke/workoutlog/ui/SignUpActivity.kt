package dev.waceke.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.waceke.workoutlog.databinding.ActivitySignUpBinding
import dev.waceke.workoutlog.models.RegisterRequest
import dev.waceke.workoutlog.models.RegisterResponse
import dev.waceke.workoutlog.api.ApiClient
import dev.waceke.workoutlog.api.ApiInterface
import dev.waceke.workoutlog.viewModel.UserViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val userViewModel: UserViewModel by viewModels()
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }

        binding.tvLogIn.setOnClickListener {
            val intent=Intent(this,LogInActivity::class.java)
            startActivity(intent)
        }

    }

    fun validateSignUp() {
        var firstname = binding.etFirstName.text.toString()
        var lastname = binding.etLastName.text.toString()
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var confirm = binding.etConfirm.text.toString()
        var phoneNumber = binding.etPhoneNumber.text.toString()
        var error = false



        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
        }
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirmation is required"
        }
        if (phoneNumber.isBlank()) {
            binding.tilPhoneNumber.error = "Password is required"
        }
        if (firstname.isBlank()) {
            binding.tilFirstName.error = "Firstname is required"
        }
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Lastname is required"
        }
            if (!error)
    {
        val registerRequest = RegisterRequest(firstname, lastname, email, phoneNumber, password)
        makeRegistrationRequest(registerRequest)

        startActivity(Intent(this, LogInActivity::class.java))
        userViewModel.registerUser(registerRequest)
            }
    }
    override fun onResume(){
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse ->
            Toast.makeText(baseContext, registerResponse?.message, Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LogInActivity::class.java))
        })

        userViewModel.registerErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
            startActivity(Intent(baseContext,LogInActivity::class.java))

        })
    }
    fun makeRegistrationRequest(registerRequest: RegisterRequest) {
        var ApiClient = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = ApiClient.registerUser(registerRequest)

        request.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    var message = response.body()?.message

//                    Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()

                } else {
                    val error = response.errorBody()?.toString()
//                    Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }
        })
    }
}



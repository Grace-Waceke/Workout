package dev.waceke.workoutlog.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.waceke.workoutlog.databinding.ActivitySignUpBinding
import dev.waceke.workoutlog.models.RegisterRequest
import dev.waceke.workoutlog.models.RegisterResponse
import dev.waceke.workoutlog.retrofit.ApiClient
import dev.waceke.workoutlog.retrofit.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSignUp.setOnClickListener {
            validateSignUp()

        }
//        binding.b.setOnClickListener {
//           val intent = Intent(this, LogInActivity::class.java)
//          startActivity(intent)
//        }

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
            var error = true
            binding.tilEmail.error = "Email is required"
        }
        if (password.isBlank()) {
            var error = true
            binding.tilPassword.error = "Password is required"
        }
        if (confirm.isBlank()) {
            var error = true
            binding.tilConfirm.error = "Confirmation is required"
        }
        if (firstname.isBlank()) {
            var error = true
            binding.tilFirstName.error = "Firstname is required"
        }
        if (lastname.isBlank()) {
            var error = true
            binding.tilLastName.error = "Lastname is required"
        }
    }
//    if (!error)
//    {
//        val registerRequest = RegisterRequest()
//        val registerRequest = RegisterRequest(firstname, lastname, email, phoneNumber, password)
//    }
//}
fun makeRegistrationRequest(registerRequest: RegisterRequest){
    var ApiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    var request = ApiClient.registerUser(registerRequest)

    request.enqueue(object : Callback<RegisterResponse> {
        override fun onResponse(
            call: Call<RegisterResponse>,
            response: Response<RegisterResponse>
        ) {
            if (response.isSuccessful){
                var message = response.body()?.message
                Toast.makeText(baseContext,message,Toast.LENGTH_LONG).show()
//                intent to login
            }else{
                val error = response.errorBody()?.toString()
                Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
            }
        }

        override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
        }


    })
}
}


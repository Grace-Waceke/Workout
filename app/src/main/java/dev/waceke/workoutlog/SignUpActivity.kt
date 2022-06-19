package dev.waceke.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.waceke.workoutlog.databinding.ActivityLogInBinding
import dev.waceke.workoutlog.databinding.ActivitySignUpBinding

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

    fun validateSignUp(){
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var confirm = binding.etConfirm.text.toString()
        var firstname = binding.etFirstName.text.toString()
        var lastname= binding.etLastName.text.toString()



        if (email.isBlank()){
            binding.tilEmail.error = "Email is required"
        }
        if (password.isBlank()){
            binding.tilPassword.error = "Password is required"
        }
        if (confirm.isBlank()){
            binding.tilConfirm.error = "Confirmation is required"
        }
        if (firstname.isBlank()){
            binding.tilFirstName.error = "Firstname is required"
        }
        if (lastname.isBlank()){
            binding.tilLastName.error = "Lastname is required"
        }
    }
}


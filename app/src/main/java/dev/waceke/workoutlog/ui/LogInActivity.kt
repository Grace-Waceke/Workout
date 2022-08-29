package dev.waceke.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.waceke.workoutlog.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding:ActivityLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)



       binding.btnLogIn .setOnClickListener {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
                 validateLogIn()
        }
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }




    }
    fun validateLogIn(){
        var email = binding.etEmail.text.toString()
        var password = binding.etPassword.text.toString()
        var  error = false

        if (email.isBlank()){
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()){
            binding.tilPassword.error = "Password is required"
            error = true

    }
        if (!error){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
}
}
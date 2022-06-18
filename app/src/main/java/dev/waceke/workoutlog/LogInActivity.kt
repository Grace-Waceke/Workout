package dev.waceke.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LogInActivity : AppCompatActivity() {
    lateinit var btnLogIn: Button
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var tvSignUp:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        btnLogIn = findViewById(R.id.btnLogIn)
        tilEmail =findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        tvSignUp = findViewById(R.id.tvSignUp)

        btnLogIn.setOnClickListener {
//            val intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
                 validateLogIn()
        }
        tvSignUp.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }




    }
    fun validateLogIn(){
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var  error = false

        if (email.isBlank()){
            tilEmail.error = "Email is required"
            error = true
        }
        if (password.isBlank()){
            tilPassword.error = "Password is required"
            error = true

    }
        if (!error){
            startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
}
}
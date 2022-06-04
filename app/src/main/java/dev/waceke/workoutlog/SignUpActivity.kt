package dev.waceke.workoutlog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity : AppCompatActivity() {
    lateinit var btnSignUp: Button
    lateinit var tilFirstName: TextInputLayout
    lateinit var tilLastName: TextInputLayout
    lateinit var tilEmail: TextInputLayout
    lateinit var tilPassword: TextInputLayout
    lateinit var tilConfirm: TextInputLayout
    lateinit var etFirstName: TextInputEditText
    lateinit var etLastName: TextInputEditText
    lateinit var etEmail: TextInputEditText
    lateinit var etPassword: TextInputEditText
    lateinit var etConfirm: TextInputEditText
    lateinit var tvLogIn: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        btnSignUp = findViewById(R.id.btnSignUp)
        tilFirstName = findViewById(R.id.tilFirstName)
        tilLastName = findViewById(R.id.tilLastName)
        tilEmail =findViewById(R.id.tilEmail)
        tilPassword = findViewById(R.id.tilPassword)
        tilConfirm = findViewById(R.id.tilConfirm)
        etFirstName = findViewById(R.id.etFirstName)
        etLastName = findViewById(R.id.etLastName)
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        etConfirm = findViewById(R.id.etConfirm)
        tvLogIn = findViewById(R.id.tvLogIn)

        btnSignUp.setOnClickListener {
            validateSignUp()
        }
        tvLogIn.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
        }

    }

    fun validateSignUp(){
        var email = etEmail.text.toString()
        var password = etPassword.text.toString()
        var confirm = etConfirm.text.toString()
        var firstname = etFirstName.text.toString()
        var lastname= etLastName.text.toString()



        if (email.isBlank()){
            tilEmail.error = "Email is required"
        }
        if (password.isBlank()){
            tilPassword.error = "Password is required"
        }
        if (confirm.isBlank()){
            tilConfirm.error = "Confirmation is required"
        }
        if (firstname.isBlank()){
            tilFirstName.error = "Firstname is required"
        }
        if (lastname.isBlank()){
            tilLastName.error = "Lastname is required"
        }
    }
}


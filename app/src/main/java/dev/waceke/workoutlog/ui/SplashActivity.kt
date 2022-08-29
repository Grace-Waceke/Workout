package dev.waceke.workoutlog.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        var intent=Intent(this, LogInActivity::class.java)
        startActivity(Intent(this, LogInActivity::class.java))
        finish()
    }
}
package dev.waceke.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashActivity : AppCompatActivity() {
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPrefs=getSharedPreferences("WORKOprofileIdUT_PREPS", MODE_PRIVATE)

        val accessToken= sharedPrefs.getString("access_token", "")
        if (accessToken!!.isBlank()){
            startActivity(Intent(this, LogInActivity::class.java))
        }
        startActivity(Intent(this, HomeActivity::class.java))

//        var intent=Intent(this, LogInActivity::class.java)
        finish()
    }
}
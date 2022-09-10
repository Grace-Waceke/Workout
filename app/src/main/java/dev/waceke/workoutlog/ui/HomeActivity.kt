package dev.waceke.workoutlog.ui

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.waceke.workoutlog.R
import dev.waceke.workoutlog.databinding.ActivityHomeBinding
import dev.waceke.workoutlog.models.LoginResponse

class HomeActivity : AppCompatActivity() {
lateinit var binding: ActivityHomeBinding
lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvLogout.setOnClickListener{
            startActivity(Intent(this,LogInActivity::class.java))


        }
        castViews()
        setupBottomNav()

    }

    fun castViews() {
        binding.fcvHome
        binding.bnvHome
    }

    fun setupBottomNav() {
        binding.bnvHome.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.Plan -> {
                    val transaction = supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fcvHome, PlanFragment())
                    transaction.commit()
                    true
                }
                R.id.Track -> {
                   supportFragmentManager.beginTransaction()
                    .replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.Profile -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else -> false

            }
        }

    }
     fun logoutRequest(){
         sharedPrefs.edit().clear().commit()
}
}
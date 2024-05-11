package com.example.api


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.databinding.DataBindingUtil
import com.example.api.databinding.ActivityLandingBinding


class Landing: AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this@Landing,R.layout.activity_landing)
        with(binding){
            supportActionBar?.hide()
            Handler().postDelayed({
                val intent= Intent(this@Landing,MainActivity::class.java)
                startActivity(intent)
            }, 3000)


        }
    }
}
package com.example.interviewpreparation.presentation

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.interviewpreparation.R
import com.example.interviewpreparation.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_splash)
        binding.lifecycleOwner=this
        startMainActivity()
        finish()
    }

    private fun startMainActivity() {
        Log.d("AMAN","Splash Activity")
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}
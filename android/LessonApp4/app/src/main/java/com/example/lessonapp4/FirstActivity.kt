package com.example.lessonapp4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lessonapp4.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRunIntent.setOnClickListener { openSecondScreen() }
    }

    private fun openSecondScreen() {
        val intent = SecondActivity.newIntent(this)
        startActivity(intent)
    }
}
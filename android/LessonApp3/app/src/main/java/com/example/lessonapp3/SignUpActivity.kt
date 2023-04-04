package com.example.lessonapp3

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessonapp3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val goBackButton = binding.ibtnGoBack

        goBackButton.setOnClickListener {
            val intent = Intent(this@SignUpActivity, EnterActivity::class.java)
            startActivity(intent)
        }
    }
}
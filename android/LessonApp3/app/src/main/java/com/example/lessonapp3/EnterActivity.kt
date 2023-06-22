package com.example.lessonapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessonapp3.databinding.ActivityEnterBinding

class EnterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEnterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityEnterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signInButton = binding.btnSignIn
        val signUpButton = binding.btnSignUp

        signInButton.setOnClickListener {
            val intent = Intent(this@EnterActivity, SignInActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this@EnterActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
package com.example.lessonapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessonapp3.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity(), SignUpInterface.View {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val presenter=SignUpPresenter(this)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toEnterActivityButton = binding.ibtnToEnterActivity

        val loginField=binding.etLogin
        val nameField=binding.etName
        val passwordField=binding.etPassword
        val passwordConfirmField=binding.etConfirmPassword

        toEnterActivityButton.setOnClickListener {
            navigationToEnterActivity()
        }
    }

    override fun navigationToEnterActivity() {
        val intent = Intent(this@SignUpActivity, EnterActivity::class.java)
        startActivity(intent)
    }
}



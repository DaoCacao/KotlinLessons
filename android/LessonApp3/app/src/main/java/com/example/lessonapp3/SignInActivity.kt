package com.example.lessonapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.lessonapp3.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity(), SignInObject.View {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var presenter: SignInPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val presenter = SignInPresenter(this, UserService())


        binding.ibtnToEnterActivity.setOnClickListener {
            navigationToEnterActivity()
        }

        binding.etLogin.doAfterTextChanged {
            presenter.loginInput(it.toString())
        }

        binding.etPassword.doAfterTextChanged {
            presenter.passwordInput(it.toString())
        }
        binding.btnSignIn.setOnClickListener {
            presenter.signInInterface()
        }
    }



    override fun userNotFoundException() {
        TODO("Not yet implemented")
    }
    override fun invalidPAsswordException() {
        TODO("Not yet implemented")
    }

    override fun navigationToEnterActivity() {
        val intent = Intent(this@SignInActivity, EnterActivity::class.java)
        startActivity(intent)
    }

    override fun navigationToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
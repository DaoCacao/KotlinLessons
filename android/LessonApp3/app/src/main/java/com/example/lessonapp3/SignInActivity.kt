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
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = SignInPresenter(this, UserService())


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

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }


    override fun disableErrors() {
        binding.ilLogin.error = null
        binding.ilPassword.error = null
    }

    override fun userNotFoundException() {
        binding.ilLogin.error = "User didn't found"
    }

    override fun invalidPAsswordException() {
        binding.ilPassword.error = "Invalid password"
    }

    override fun navigationToEnterActivity() {
        val intent = Intent(this@SignInActivity, EnterActivity::class.java)
        startActivity(intent)
    }

    override fun navigationToMainActivity() {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(ID, presenter.getId())
        }
        startActivity(intent)
    }

    companion object {
        val ID = "id"
    }
}

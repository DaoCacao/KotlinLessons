package com.example.lessonapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.lessonapp3.databinding.ActivitySignUpBinding


class SignUpActivity : AppCompatActivity(), SignUpObject.View {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var presenter: SignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        presenter = SignUpPresenter(this, UserService())
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.etLogin.doAfterTextChanged {
            presenter.loginInput(it.toString())
        }
        binding.etName.doAfterTextChanged {
            presenter.nameInput(it.toString())
        }
        binding.etPassword.doAfterTextChanged {
            presenter.passwordInput(it.toString())
        }
        binding.etConfirmPassword.doAfterTextChanged {
            presenter.confirmPasswordInput(it.toString())
        }

        binding.btnSignUn.setOnClickListener {
            presenter.signUp_interface()

        }

        binding.ibtnToEnterActivity.setOnClickListener {
            navigationToEnterActivity()
        }
    }

    override fun disableErrors() {
        binding.ilName.error = null
        binding.ilLogin.error = null
        binding.ilPassword.error = null
        binding.ilConfirmPassword.error = null
    }

    override fun inavalidName() {
        binding.ilName.error = "Invalid name. Enter at least 3 characters"
    }

    override fun invalidLogin() {
        binding.ilLogin.error = "Invalid login. Enter at least 3 characters"
    }

    override fun invalidPassword() {
        binding.ilPassword.error = "Invalid password. Enter at least 6 characters"
    }

    override fun invalidConfirmPassword() {
        binding.ilConfirmPassword.error = "Passwords are different"
    }

    override fun userAlreadyExist() {
        TODO("Not yet implemented")
    }

    override fun navigationToEnterActivity() {
        val intent = Intent(this@SignUpActivity, EnterActivity::class.java)
        startActivity(intent)

    }

    override fun navigationToMainActivity(id: Int) {
        val intent = Intent(this@SignUpActivity, MainActivity::class.java).apply {
            putExtra(ID, id)
        }
        startActivity(intent)
    }

    companion object SignUpCompanion {
        private const val ID = "id"
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }
}



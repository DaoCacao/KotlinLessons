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

        val presenter = SignUpPresenter(this, UserService())
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.ilLogin.error="Invalid login"

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


    override fun inavalidName() {
        TODO("Not yet implemented")
    }

    override fun invalidLogin() {
        TODO("Not yet implemented")
    }

    override fun invalidPassword() {
        TODO("Not yet implemented")
    }

    override fun invalidConfirmPassword() {
        TODO("Not yet implemented")
    }

    override fun navigationToEnterActivity() {
        val intent = Intent(this@SignUpActivity, EnterActivity::class.java)
        startActivity(intent)

    }

    override fun navigationToMainActivity() {
        val intent = Intent(this@SignUpActivity, MainActivity::class.java).apply {
//            putExtra(
//                "id",
//                presenter.idToMainActivity()
//            )
        }
        startActivity(intent)
    }


}



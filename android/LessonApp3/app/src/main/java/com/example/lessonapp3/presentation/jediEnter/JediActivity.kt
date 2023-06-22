package com.example.lessonapp3.presentation.jediEnter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.doAfterTextChanged
import com.example.lessonapp3.R
import com.example.lessonapp3.UserService
import com.example.lessonapp3.data.remote.JediGetter
import com.example.lessonapp3.data.remote.JediRemoteStorage
import com.example.lessonapp3.databinding.ActivityJediBinding
import com.example.lessonapp3.presentation.enter.EnterActivity
import com.example.lessonapp3.presentation.main.MainActivity

class JediActivity : AppCompatActivity(), JediObject.View {

    private lateinit var binding: ActivityJediBinding
    private lateinit var presenter: JediObject.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityJediBinding.inflate(layoutInflater)
        presenter = JediPresenter(this, JediRemoteStorage(), UserService(), JediGetter(JediRemoteStorage()))
        setContentView(binding.root)
        presenter.getAllJedi()


        binding.etjediName.doAfterTextChanged {
            presenter.jediNameInput(it.toString())
        }
        binding.etjediPassword.doAfterTextChanged {
            presenter.jediPasswordInput(it.toString())
        }
        binding.btnJediSignIn.setOnClickListener {
            presenter.signInAsJedi()
        }

        binding.ibtnToEnterActivity.setOnClickListener {
            navigateToEnterActivity()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }

    override fun navigateToEnterActivity() {

        val intent = Intent(this@JediActivity, EnterActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToMainActivity(jediID: Int) {
        val intent = Intent(this@JediActivity, MainActivity::class.java).apply {
            putExtra(ID, jediID)
        }
        startActivity(intent)
    }

    override fun disableErrors() {
        binding.nameInput.error=null
        binding.passwordInput.error=null
    }
    override fun showWrongName() {
        binding.nameInput.error = getString(R.string.wrong_jedi_name)
    }

    override fun userAlreadyExist() {
        binding.nameInput.error=getString(R.string.user_already_exist)
    }

    override fun invalidPassword() {
        binding.passwordInput.error= getString(R.string.short_password)
    }

    companion object {
        val ID = "id"
    }
}
package com.example.cleanarchitecture.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.cleanarchitecture.databinding.ActivityMainBinding
import com.example.cleanarchitecture.di.providePresenter
import com.example.cleanarchitecture.domain.model.UserModel

class MainActivity : AppCompatActivity(), Main.View {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val presenter: Main.Presenter by lazy { providePresenter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.input.doAfterTextChanged {
            presenter.updateId(it.toString())
        }
        binding.buttonLoadUser.setOnClickListener {
            presenter.loadUser()
        }
    }

    override fun showUser(user: UserModel) {
        binding.textUsername.text = "${user.id}: ${user.name} ${user.password}"
    }
}
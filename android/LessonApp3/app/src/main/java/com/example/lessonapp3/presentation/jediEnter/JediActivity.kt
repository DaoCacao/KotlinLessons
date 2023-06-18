package com.example.lessonapp3.presentation.jediEnter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessonapp3.R
import com.example.lessonapp3.databinding.ActivityEnterBinding
import com.example.lessonapp3.databinding.ActivityJediBinding
import com.example.lessonapp3.presentation.enter.EnterActivity
import com.example.lessonapp3.presentation.main.MainActivity

class JediActivity : AppCompatActivity(), JediObject.View {

    private lateinit var binding: ActivityJediBinding
    private lateinit var presenter: JediObject.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJediBinding.inflate(layoutInflater)
        presenter = JediPresenter(this)


    }


    override fun navigateToEnterActivity() {

        val intent = Intent(this, EnterActivity::class.java)
        startActivity(intent)
    }

    override fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    override fun showWrongName() {
        binding.nameInput.error=getString(R.string.wrong_jedi_name)
    }
}
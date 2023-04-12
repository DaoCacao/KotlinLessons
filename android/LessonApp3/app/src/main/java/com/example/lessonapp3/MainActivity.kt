package com.example.lessonapp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessonapp3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainObject.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var presenter=MainPresenter(this)

        binding.btnSigninOut.setOnClickListener {
            signOut()
        }
    }

    override fun signOut() {
        val intent= Intent(this, EnterActivity::class.java)
        startActivity(intent)
    }
}
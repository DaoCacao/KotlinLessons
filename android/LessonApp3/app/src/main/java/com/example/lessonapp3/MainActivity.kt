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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MainPresenter(this, UserService())
        presenter.userInitialization(intent.getIntExtra(ID, 0))

        binding.btnSigninOut.setOnClickListener {
            presenter.signOut()
        }
    }

    override fun navigationToEnterActivity() {
        val intent = Intent(this, EnterActivity::class.java)
        startActivity(intent)
    }

    override fun welcomText(user: Boolean) {
        return if (user){
            binding.tvMainActivity.text ="You are welcome, ${presenter._user.name}"
        }else{
            binding.tvMainActivity.text ="We can't find you, maybe you don't exist"
        }
    }

    companion object {
        var ID = "id"
        fun toMainActivity() {
        }
    }
}

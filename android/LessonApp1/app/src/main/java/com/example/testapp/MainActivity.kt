package com.example.testapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.databinding.ActivityFrameBinding

// Activity - базовый класс
// ComponentActivity
// FragmentActivity - FragmentManager
// AppCompatActivity
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityFrameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val textView1 = delegate.findViewById<TextView>(R.id.tv_title)
        val textView2 = binding.textSubtitle
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
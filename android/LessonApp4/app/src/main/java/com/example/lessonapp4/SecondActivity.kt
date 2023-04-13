package com.example.lessonapp4

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import androidx.core.net.toUri
import com.example.lessonapp4.databinding.ActivitySecondBinding
import kotlin.random.Random


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val value = intent.getIntExtra(VALUE, -1)
        binding.text.text = "${binding.text.text} = {$value}"

        binding.buttonRunIntent.setOnClickListener { openAnotherApp() }
        binding.buttonRunIntentMail.setOnClickListener { openMail() }
    }

    //intent.flags
    private fun openAnotherApp() {
        val intent = Intent(Intent.ACTION_VIEW, "https://www.vk.ru".toUri())
        val chooser = Intent.createChooser(intent, "Выбери приложение чорт")
        startActivity(chooser)
    }

    private fun openMail() {
        val email = "mrdaocacao@gmail.com"
        val subject = "Слышь чорт"
        val body = "Займи 5 тыщщщ! :-)"

//        val uri = Uri.parse("mailto:$email")
//            .buildUpon()
//            .appendQueryParameter("subject", subject)
//            .appendQueryParameter("body", body)
//            .build()
//
//        val intent = Intent(Intent.ACTION_SENDTO, uri)
//        val chooser = Intent.createChooser(intent, "Выбери почту чорт")
//        startActivity(chooser)


        val intent = ShareCompat.IntentBuilder(this)
            .addEmailTo(email)
            .setSubject(subject)
            .intent
        val packageManager: PackageManager = packageManager
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("OOPS", "No Intent available to handle action")
        }
    }

    companion object {
        private const val VALUE = "value"

        fun newIntent(context: Context): Intent {
            return Intent(context, SecondActivity::class.java).apply {
                putExtra(VALUE, Random.nextInt(0, 100))
            }
        }
    }
}
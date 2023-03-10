package com.example.lessonapp2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.example.lessonapp2.databinding.ActivityMainBinding
import kotlin.random.Random

// Programming patterns
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter = MainPresenter(this, Calculator())

        binding.editNumber.setText("")
        binding.editNumber.isEnabled = true
        binding.editNumber.doAfterTextChanged { presenter.onNumberChange(it.toString()) }
        binding.buttonSubmit.setOnClickListener { presenter.onButtonClick() }
    }

    fun showResult(result: Result) {
        when (result.error) {
            Result.Error.NoError -> {
                binding.textTitle.text = result.value.toString()
            }
            Result.Error.CannotCalculate -> {
                binding.textTitle.text = "Cannot calculate"
            }
        }
    }
}

class MainPresenter(
    private val view: MainActivity,
    private val calculator: Calculator,
) {
    private var number: Int = 0

    fun onButtonClick() {
        val result = calculator.calculateResult(number)
        view.showResult(result)
    }

    fun onNumberChange(number: String) {
        this.number = number.toIntOrNull() ?: 0
    }
}

class Calculator {

    fun calculateResult(number: Int): Result {
        return if (Random.nextInt(0, 3) == 0) {
            Result(0, Result.Error.CannotCalculate)
        } else {
            val value = Random.nextInt(0, 10) + number
            Result(value, Result.Error.NoError)
        }
    }
}

data class Result(
    val value: Int,
    val error: Error,
) {
    enum class Error {
        NoError,
        CannotCalculate,
    }
}
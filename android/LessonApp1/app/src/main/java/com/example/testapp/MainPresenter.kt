package com.example.testapp

public class MainPresenter(private val _view: MainActivity) {
    var positionNumber: Int? = 0
    var fiboResult: Int=0

    fun fibonachi(): Int {
        var i = 1
        var fib1 = 0
        var fib2 = 1
        var fib3 = 0

        while (i != this.positionNumber) {

            fib3 = fib1 + fib2
            fib1 = fib2
            fib2 = fib3
            i++
        }
        when (i) {
            1 -> this.fiboResult = 0
            2 -> this.fiboResult = 1
            else -> this.fiboResult = fib3
        }

        return fiboResult
    }
    fun onButtonClick(){
        fibonachi()
        _view.showResult(this.fiboResult)
        _view.buttonDisEnabling()
    }

    fun onNumberInput(_positionNumber: String) {
        positionNumber = _positionNumber.toIntOrNull()
    }

}
